package com.ravi.fintrack.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ravi.fintrack.model.Transaction;

public class TrasactionDaoImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrasactionDaoImpl.class);

	@PersistenceContext
    private EntityManager entityManager;
	
	public TrasactionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	//@Override
	public List<Transaction> findByProperties(Map<String, Object> propMap) throws Exception {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Transaction> query = cb.createQuery(Transaction.class);
		Root<Transaction> trcnRoot = query.from(Transaction.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		// constructing query
		for (Entry<String, Object> entryMap : propMap.entrySet()) {
			if("description".equalsIgnoreCase(entryMap.getKey()) && 
					entryMap.getValue() != null) {
				 Expression<String> path = trcnRoot.get(entryMap.getKey());
				predicates.add(cb.like(path, entryMap.getValue().toString()));
			} if("fromDate".equalsIgnoreCase(entryMap.getKey()) && 
					entryMap.getValue() != null){
				predicates.add(cb.greaterThanOrEqualTo(trcnRoot.get("purchasedDate"), (Date)entryMap.getValue()));
			} if("toDate".equalsIgnoreCase(entryMap.getKey()) && 
					entryMap.getValue() != null){
				predicates.add(cb.lessThanOrEqualTo(trcnRoot.get("purchasedDate"), (Date)entryMap.getValue()));
			} else {
				predicates.add(cb.equal(trcnRoot.get(entryMap.getKey()), entryMap.getValue()));
			}
		}
		
		// adding order by clause
		query.orderBy(cb.desc(trcnRoot.get("purchasedDate"))).select(trcnRoot)
				.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

		return entityManager.createQuery(query).getResultList();
	}

}
