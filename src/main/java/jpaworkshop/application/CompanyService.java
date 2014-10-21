/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package jpaworkshop.application;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jpaworkshop.entities.Address;
import jpaworkshop.entities.Department;
import jpaworkshop.entities.DesignProject;
import jpaworkshop.entities.Employee;
import jpaworkshop.entities.PhoneType;
import jpaworkshop.entities.QualityProject;


@Singleton
public class CompanyService {
    private static final Logger logger = Logger.getLogger(CompanyService.class.getName());
    
    @PersistenceContext(unitName = "company-pu")
    private EntityManager entityManager;
    
    @PostConstruct
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void initializeDatamodel() {
	Employee test = entityManager.find(Employee.class, 1);
	if (test != null) {
	    logger.info("Already initialized, skipping initialization");
	    return;
	}
	
	Department engineering = persist(new Department(1, "Engineering"));
	Department hr = persist(new Department(2, "HR"));
	
	Employee alice = persist(new Employee(1, "Alice", 1200));
	hr.add(alice);
	Address address1 = persist(new Address(1, "Street 123", "Testcity", "Test state" , "1234 AA"));
	alice.setAddress(address1);
	alice.addPhone(PhoneType.CELL, "012345");
	
	Employee mark = persist(new Employee(2, "Mark", 1300));
	Employee bob = persist(new Employee(3, "Bob", 1000));
	engineering.add(bob);
	Employee john = persist(new Employee(4, "John", 1500));
	engineering.add(john);
	
	john.addDirect(bob);
	
	QualityProject qualityProject1 = persist(new QualityProject(1, "Quality project 1", 3));
	QualityProject qualityProject2 = persist(new QualityProject(2, "Quality project 2", 4));
	DesignProject designProject = persist(new DesignProject(3, "Design project 1"));
	
	qualityProject1.assignEmployee(john);
	qualityProject1.assignEmployee(mark);
	
	designProject.assignEmployee(alice);
	
	logger.info("Data model initialized");
    }

    /**
     * Helper method for persisting the given entity and returning the same value.
     * 
     * @param entity the entity to be persisted
     * @return the given entity
     */
    private <T> T persist(T entity) {
	entityManager.persist(entity);
	
	return entity;
    }

    public List executeQuery(String query)
    {
        List resultList = entityManager.createQuery(query).getResultList();
        
        logger.log(Level.INFO, "returning {0} results", resultList.size());
        
	return resultList;
    }
}
