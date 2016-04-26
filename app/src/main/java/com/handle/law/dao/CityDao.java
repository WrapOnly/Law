package com.handle.law.dao;

public class CityDao {
	
	public static Object[] queryProvince() {
		Object[] result = null;
		try {
			String rawQuerySql = "SELECT * FROM provinces";
//			result = WebuyApp.getInstance().getRoot().getWebuyDB().rawQuery(rawQuerySql, null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Object[] queryCity(String _ProvinceID) {
		Object[] result = null;
		try {
			String[] whereArgs	= { _ProvinceID };
			String rawQuerySql = "SELECT * FROM citys WHERE ProvinceID=?";
//			result = WebuyApp.getInstance().getRoot().getWebuyDB().rawQuery(rawQuerySql, whereArgs);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Object[] queryAllCities() {
		Object[] result = null;
		try {
			String rawQuerySql = "SELECT * FROM citys";
//			result = WebuyApp.getInstance().getRoot().getWebuyDB().rawQuery(rawQuerySql, null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Object[] queryDistrict(String _CityId) {
		Object[] result = null;
		try {
			String[] whereArgs	= {  _CityId  };
			String rawQuerySql = "SELECT * FROM districts WHERE CityID=?";
//			result = WebuyApp.getInstance().getRoot().getWebuyDB().rawQuery(rawQuerySql, whereArgs);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
