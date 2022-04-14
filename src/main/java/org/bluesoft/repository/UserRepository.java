package org.bluesoft.repository;

import javax.enterprise.context.ApplicationScoped;

import org.bluesoft.models.BlUser;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<BlUser,String> {
}
