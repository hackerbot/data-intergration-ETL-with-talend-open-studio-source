package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TOracleSPBeginJava
{
  protected static String nl;
  public static synchronized TOracleSPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleSPBeginJava result = new TOracleSPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "\tconnection_";
  protected final String TEXT_5 = " = (java.sql.Connection) globalMap.get(\"";
  protected final String TEXT_6 = "\");" + NL + "\t";
  protected final String TEXT_7 = " " + NL + "\t\tif (null == connection_";
  protected final String TEXT_8 = ") {" + NL + "\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_9 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES); " + NL + "\t\t\tconnection_";
  protected final String TEXT_10 = " = dataSources_";
  protected final String TEXT_11 = ".get(";
  protected final String TEXT_12 = ").getConnection();" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_14 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\tif (null != dataSources_";
  protected final String TEXT_15 = ") {" + NL + "\t\t\tconnection_";
  protected final String TEXT_16 = " = dataSources_";
  protected final String TEXT_17 = ".get(";
  protected final String TEXT_18 = ").getConnection();" + NL + "\t\t} else {" + NL + "\t";
  protected final String TEXT_19 = NL + "\t";
  protected final String TEXT_20 = NL + "    \tjava.lang.Class.forName(\"oracle.jdbc.OracleDriver\");\t";
  protected final String TEXT_21 = NL + "\t\tjava.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");\t" + NL + "\t";
  protected final String TEXT_22 = NL + "\t";
  protected final String TEXT_23 = NL + "\t\tString connectionString_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ";        " + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\tString connectionString_";
  protected final String TEXT_27 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_28 = " + \":\" + ";
  protected final String TEXT_29 = " + \":\" + ";
  protected final String TEXT_30 = ";" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\t\tString connectionString_";
  protected final String TEXT_32 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_33 = " + \")(port=\" + ";
  protected final String TEXT_34 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_35 = " + \")))\";" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t    String connectionString_";
  protected final String TEXT_37 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_38 = ";" + NL + "\t    ";
  protected final String TEXT_39 = NL + "\t\t        " + NL + "\t";
  protected final String TEXT_40 = NL + "\t" + NL + "\t";
  protected final String TEXT_41 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_42 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = "; ";
  protected final String TEXT_47 = NL + "   \t";
  protected final String TEXT_48 = NL + "\tconnection_";
  protected final String TEXT_49 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = ", decryptedPassword_";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\tString atnParams_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = ";" + NL + "\tatnParams_";
  protected final String TEXT_56 = " = atnParams_";
  protected final String TEXT_57 = ".replaceAll(\"&\", \"\\n\");" + NL + "\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_58 = " = new java.util.Properties();" + NL + "\tatnParamsPrope_";
  protected final String TEXT_59 = ".put(\"user\",";
  protected final String TEXT_60 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_61 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_62 = ");" + NL + "\tatnParamsPrope_";
  protected final String TEXT_63 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_64 = ".getBytes()));" + NL + "\tconnection_";
  protected final String TEXT_65 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_66 = ", atnParamsPrope_";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_69 = NL + "\tjava.sql.Statement stmtNLS_";
  protected final String TEXT_70 = " = connection_";
  protected final String TEXT_71 = ".createStatement();";
  protected final String TEXT_72 = "\t" + NL + "\t\tstmtNLS_";
  protected final String TEXT_73 = ".execute(\"ALTER SESSION SET NLS_LANGUAGE=\" +\"";
  protected final String TEXT_74 = "\" );";
  protected final String TEXT_75 = "\t" + NL + "\t\tstmtNLS_";
  protected final String TEXT_76 = ".execute(\"ALTER SESSION SET NLS_TERRITORY=\" +\"";
  protected final String TEXT_77 = "\" );";
  protected final String TEXT_78 = NL + NL + "java.sql.CallableStatement statement_";
  protected final String TEXT_79 = " = connection_";
  protected final String TEXT_80 = ".prepareCall(\"{";
  protected final String TEXT_81 = "call \" + ";
  protected final String TEXT_82 = " + \"(";
  protected final String TEXT_83 = "?";
  protected final String TEXT_84 = ",?";
  protected final String TEXT_85 = ")}\");" + NL + "" + NL + "java.sql.Timestamp tmpDate_";
  protected final String TEXT_86 = ";" + NL + "String tmpString_";
  protected final String TEXT_87 = ";";
  protected final String TEXT_88 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");

	String spName = ElementParameterParser.getValue(node, "__SP_NAME__");
	boolean isFunction = ("true").equals(ElementParameterParser.getValue(node, "__IS_FUNCTION__"));
	List<Map<String, String>> spArgs = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SP_ARGS__");
	boolean useExistingConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");

	String nlsLanguage = ElementParameterParser.getValue(node, "__NLS_LANGUAGE__");
	String nlsTerritory = ElementParameterParser.getValue(node, "__NLS_TERRITORY__");
	String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
if (useExistingConnection) {
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String connectionName = "conn_" + connection;
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_6);
    
	INode connectionNode = null;
	for (INode processNode : node.getProcess().getGeneratingNodes()) {
		if(connection.equals(processNode.getUniqueName())) {
			connectionNode = processNode;
			break; 
		} 
	} 
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__"); 
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_12);
    
	}
} else {
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");
	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_18);
    
	}
	
    stringBuffer.append(TEXT_19);
    if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) ){
    stringBuffer.append(TEXT_20);
    }else {
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    
	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");
	if("ORACLE_RAC".equals(connectionType)) {
		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_25);
    
	} else if(("ORACLE_SID").equals(connectionType)) {
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_30);
    
	} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {
		
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_35);
    
	} else if(("ORACLE_OCI").equals(connectionType)) {
	    
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_38);
    
	}
	
    stringBuffer.append(TEXT_39);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_40);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_43);
    } else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    
	if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	} else {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
	}
	if(specify_alias){
	
    stringBuffer.append(TEXT_68);
    
	}
}


    	
	if (!("NONE").equals(nlsLanguage) || !("NONE").equals(nlsTerritory) ) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
		if(!("NONE").equals(nlsLanguage)){

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(nlsLanguage);
    stringBuffer.append(TEXT_74);
    
		}
		if(!("NONE").equals(nlsTerritory)){

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(nlsTerritory);
    stringBuffer.append(TEXT_77);
    
		}
	}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(isFunction ? "? = " : "");
    stringBuffer.append(TEXT_81);
    stringBuffer.append(spName);
    stringBuffer.append(TEXT_82);
    
boolean isFirstArg = true;
for (int i = 0; i < spArgs.size(); i++) {
	if(isFirstArg){
		
    stringBuffer.append(TEXT_83);
    
		isFirstArg=false;
	}else{
		
    stringBuffer.append(TEXT_84);
    
	}
}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
    return stringBuffer.toString();
  }
}
