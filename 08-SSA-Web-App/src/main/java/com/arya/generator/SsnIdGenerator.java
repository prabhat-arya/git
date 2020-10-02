package com.arya.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SsnIdGenerator implements IdentifierGenerator{
	
@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

	

    try {
    	Connection connection = session.connection();
        Statement statement=connection.createStatement();

        ResultSet rs=statement.executeQuery("select count(ssn) as Id from SSN_MASTER");

        if(rs.next())
        {
        	Random rand = new Random();

        	long drand = (long)(rand.nextDouble()*1000000000L);
            Long id=rs.getLong(1)+drand;
            return id;
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return null;
}
}
