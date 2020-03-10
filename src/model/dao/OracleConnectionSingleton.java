package model.dao;
public class OracleConnectionSingleton {
	private static OracleConnection oraConn;
	private OracleConnectionSingleton() {
	}
	public static OracleConnection getOracleConnectionInstance() {
		if (oraConn==null) {
			oraConn = new OracleConnection();
		}
		return oraConn;
	}
}
