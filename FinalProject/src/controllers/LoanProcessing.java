package controllers;

/**
 * @author Andrea Perez Isla
 *
 * ITMD510 Object-Oriented App Develop
 * Lab4
 * Loan Processing class
 * 
 */
import java.sql.ResultSet;

import models.DaoModel;
import records.HairSalonRecords;

import views.LoanView;

public class LoanProcessing extends HairSalonRecords {

	public static void main(String[] args) {
		HairSalonRecords prueba = new HairSalonRecords();
		prueba.readData();
		DaoModel dao = new DaoModel();
		dao.createTable();
		dao.insertRecords(hairjs); // perform inserts
		ResultSet rs;
		rs = dao.retrieveRecords();
		new LoanView().runView(rs);
		
		

	}
}
