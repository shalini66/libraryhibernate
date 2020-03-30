package com.capgemini.librarymanagementsystemhibernate.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;

public class StudentDAOImp implements StudentDAO {

	public BookBean searchBookTitle(String bname) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//			BookBean bookBean = new BookBean();
//			BookBean bean = manager.find(BookBean.class, bookBean.getBid());
//			if(bookBean.getBname().equals(bean.getBname())) {
//				
//			}
			//manager.persist(bname);
//			manager.persist(bean);
//			transaction.commit();
//			return bean;
			
			String jpql = "select * from bookbean m where m.bname =:mbname";
			TypedQuery<BookBean> query = (TypedQuery<BookBean>) manager.createNativeQuery(jpql, BookBean.class);
			query.setParameter("mbname", bname);
			List<BookBean> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				BookBean bean = (BookBean) it.next();
				System.out.println("----------------------");
				System.out.print("Id:---"+bean.getBid());
				System.out.print(" Name:---"+bean.getBname());
				System.out.println(" Author:---"+bean.getAuthor());
				System.out.println("PublisherName:---"+bean.getPublishername());
				System.out.println("Category:---"+bean.getCategory());
			}
			transaction.commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public BookBean searchBookAuthor(String bAuthor) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//			BookBean bean = manager.find(BookBean.class, bAuthor);
//			//manager.persist(bAuthor);
//			manager.persist(bean);
//			transaction.commit();
//			return bean;
			
			String jpql = "select * from bookbean m where m.author =:mauthor";
			TypedQuery<BookBean> query = (TypedQuery<BookBean>) manager.createNativeQuery(jpql, BookBean.class);
			query.setParameter("mauthor", bAuthor);
			List<BookBean> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				BookBean bean = (BookBean) it.next();
				System.out.println("----------------------");
				System.out.print("Id:---"+bean.getBid());
				System.out.print(" Name:---"+bean.getBname());
				System.out.println(" Author:---"+bean.getAuthor());
				System.out.println("PublisherName:---"+bean.getPublishername());
				System.out.println("Category:---"+bean.getCategory());
			}
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public BookBean searchBookType(int bid) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean bean = manager.find(BookBean.class, bid);
			//manager.persist(bid);;
			manager.persist(bean);
			transaction.commit();
			return bean;
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

		return null;
	}

	public LinkedList<Integer> getBookIds() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			String jpql = "select * from bookbean";
			Query query =  manager.createNativeQuery(jpql, BookBean.class);
			List<Integer> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				BookBean bean = (BookBean) it.next();
				System.out.println("----------------------");
				System.out.println("Id:---"+bean.getBid());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public LinkedList<BookBean> getBooksInfo() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			String jpql = "select * from bookbean";
			TypedQuery<BookBean> query = (TypedQuery<BookBean>) manager.createNativeQuery(jpql, BookBean.class);
			List<BookBean> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				BookBean bean = (BookBean) it.next();
				System.out.println("----------------------");
				System.out.print("Id:---"+bean.getBid());
				System.out.print(" Name:---"+bean.getBname());
				System.out.println(" Author:---"+bean.getAuthor());
				System.out.println("PublisherName:---"+bean.getPublishername());
				System.out.println("Category:---"+bean.getCategory());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public RequestBean requestBook(UsersBean student, BookBean book) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			RequestBean requestInfo = new RequestBean();
			//manager.persist(requestInfo);
			UsersBean usersInfo = new UsersBean();
			BookBean bookInfo = new BookBean();
			boolean flag = false;
			boolean isRequestExists = false;

			RequestBean bean = manager.find(RequestBean.class, requestInfo.getRid() );
			manager.persist(bean);
			//manager.merge(bean);
			if(bookInfo.getBid() == bean.getBookInfo().getBid()) {
				isRequestExists = true;
			}

			if (!isRequestExists) {
				UsersBean usersBean = manager.find(UsersBean.class, student.getEmail());
				manager.persist(usersBean);
				//manager.merge(usersBean);
				if(usersInfo.getId() == usersBean.getId()){
					BookBean bookBean = manager.find(BookBean.class, book.getBid());
					manager.persist(bookBean);
					//manager.merge(bookBean);
					if(bookInfo.getBid() == bookBean.getBid()) {
						usersInfo = usersBean;
						bookInfo = bookBean;
						flag = true;
					}
				}
			}

			if(flag == true) {
				requestInfo.setBookInfo(bookInfo);
				requestInfo.setUsersInfo(usersInfo);
				RequestBean requestBean = manager.find(RequestBean.class, requestInfo.getRid());
				//manager.persist(requestBean);
				//manager.persist(requestInfo);
				manager.merge(requestBean);
				return requestBean;
			}
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public boolean returnBook(UsersBean student, BookBean book) {
		// TODO Auto-generated method stub
		return false;
	}

}

