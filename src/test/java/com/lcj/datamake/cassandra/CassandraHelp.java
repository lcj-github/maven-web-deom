package com.lcj.datamake.cassandra;
/*package com.lcj.datamake;

*//**
 * 依赖cassandra-driver-core 包
 *//*
import java.sql.Timestamp;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;

public class CassandraHelp {
	
	private Cluster cluster;
	 
    private Session session;
 
    public Cluster getCluster() {
        return cluster;
    }
 
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
 
    public Session getSession() {
        return session;
    }
 
    public void setSession(Session session) {
        this.session = session;
    }
    
    
    *//**
     * 连接节点
     * 
     * @param node
     *//*
    public void connect(String node) {
        //cluster = Cluster.builder().addContactPoint(node).build();
    	
    	QueryOptions queryOptions = new QueryOptions().setConsistencyLevel(ConsistencyLevel.ONE);
		final SocketOptions socketOptions = new SocketOptions()
		        .setConnectTimeoutMillis(5000)
		        .setReadTimeoutMillis(10000);
    	 cluster = Cluster
    	        .builder()
    	        .addContactPoints(node)
    	        .withPort(9042)
    	        //.withQueryOptions(queryOptions)
    	        //.withSocketOptions(socketOptions)
    	        //.withLoadBalancingPolicy(new TokenAwarePolicy(new RoundRobinPolicy()))
    	        //.withAuthProvider(new PlainTextAuthProvider("bankw", "bankw@uyt"))
    	        .build(); 
 
        this.session = cluster.connect("bank");
    }
    
    public void insertData() {
    	String insertDB = "insert into bank.t_balance_log("
                +"uname,txid,amount,"
                + "amount_6,balance,balance_6,"
                + "ctime,memo,peer,txtype)"                
                + " values(?,?,?,?,?,?,?,?,?,?)";
    	
    	Timestamp dtime = new Timestamp(System.currentTimeMillis());
		
    	
    	PreparedStatement psta = getSession().prepare(insertDB);
    	BoundStatement boundSta = new BoundStatement(psta); 
    	getSession().execute(
                boundSta.bind("哗哗", 132633958809600000L, -660000L,
                		304522L, 88886699L, 456982L, dtime,"视吧充值001"
                        , "+8013",8013));
    }
    
    
  //查询数据
    public void loadData() {
        String select = "select * from bank.t_balance_log where uname='哗哗'";
        ResultSet resultSet = getSession().execute(select);
        int count=0;
        for (Row row : resultSet) {
            System.out.print("uname: "+row.getString("uname"));
            System.out.print(" txid: "+row.getLong("txid"));
            System.out.print(" amount: "+row.getLong("amount"));
            System.out.print(" amount_6: "+row.getLong("amount_6"));
            System.out.print(" balance: "+row.getLong("balance"));
            System.out.println(" balance_6: "+row.getLong("balance_6"));
            System.out.println(" ctime: "+row.getTimestamp("ctime"));
            System.out.print(" memo: "+row.getString("memo"));
            System.out.print(" peer: "+row.getString("peer"));
            System.out.print(" txtype: "+row.getInt ("txtype"));
            
            count++;
        }
        System.out.println(" 行数:"+count);
    }
    
    
    
    
    public void close() {
        cluster.close();
        System.out.println("程序正常关闭！");
    }
    
    public static void main(String[] args) {
    	CassandraHelp client = new CassandraHelp();
        client.connect("ip地址");
        client.loadData();
        // client.insertData();        
        client.session.close();
        client.close();
    }

}
*/