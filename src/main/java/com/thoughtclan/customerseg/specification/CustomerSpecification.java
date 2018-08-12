package com.thoughtclan.customerseg.specification;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.mysql.jdbc.log.Log;
import com.thoughtclan.customerseg.model.Customer;
import com.thoughtclan.customerseg.model.Customer_;
import com.thoughtclan.customerseg.model.FilterHelper;


public class CustomerSpecification {

	
	public static Specification<Customer> hasData(FilterHelper helper){
		return new Specification<Customer>() {
			public Predicate toPredicate(Root<Customer> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
				
				if (!StringUtils.isEmpty(helper.getName())) {
                    final Predicate nmPredicate = cb.like(cb.lower(root.get(Customer_.name)), helper.getName());
                    predicates.add(nmPredicate);
             }
				if (!StringUtils.isEmpty(helper.getGender())) {
					if(helper.getGender().equals("null")) {
					}
					else {
						final Predicate genderPredicate = cb.like(cb.lower(root.get(Customer_.gender)), helper.getGender());
	                    predicates.add(genderPredicate);
					}
                }
				if (!StringUtils.isEmpty(helper.getCity())) {
                    final Predicate cityPredicate = cb.like(cb.lower(root.get(Customer_.city)), helper.getCity());
                    predicates.add(cityPredicate);
                }
				if (!StringUtils.isEmpty(helper.getState())) {
                    final Predicate statePredicate = cb.like(cb.lower(root.get(Customer_.state)), helper.getState());
                    predicates.add(statePredicate);
                }
				if (!StringUtils.isEmpty(helper.getCountry())) {
                    final Predicate countryPredicate = cb.like(cb.lower(root.get(Customer_.country)), helper.getCountry());
                    predicates.add(countryPredicate);
                }
				if(helper.getMinAge()!=0&&helper.getMaxAge()!=0) {
					final Predicate agePredicate = cb.between(root.get(Customer_.age), helper.getMinAge(), helper.getMaxAge());
					predicates.add(agePredicate);
				}
				
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}
