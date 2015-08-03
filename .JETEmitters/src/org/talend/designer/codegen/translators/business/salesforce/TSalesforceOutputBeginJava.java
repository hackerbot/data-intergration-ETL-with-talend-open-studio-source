package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TSalesforceOutputBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputBeginJava result = new TSalesforceOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                if(log.is";
  protected final String TEXT_4 = "Enabled())";
  protected final String TEXT_5 = NL + "            log.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + ";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "            StringBuilder ";
  protected final String TEXT_12 = " = new StringBuilder();";
  protected final String TEXT_13 = NL + "            ";
  protected final String TEXT_14 = ".append(\"Parameters:\");";
  protected final String TEXT_15 = NL + "                    ";
  protected final String TEXT_16 = ".append(\"";
  protected final String TEXT_17 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_18 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_19 = NL + "                    ";
  protected final String TEXT_20 = ".append(\"";
  protected final String TEXT_21 = "\" + \" = \" + ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "                ";
  protected final String TEXT_24 = ".append(\" | \");";
  protected final String TEXT_25 = NL + "            StringBuilder ";
  protected final String TEXT_26 = " = new StringBuilder();    ";
  protected final String TEXT_27 = NL + "                    ";
  protected final String TEXT_28 = ".append(";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "                    if(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " == null){";
  protected final String TEXT_34 = NL + "                        ";
  protected final String TEXT_35 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_36 = NL + "                        ";
  protected final String TEXT_37 = ".append(";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ");" + NL + "                    }   ";
  protected final String TEXT_40 = NL + "                ";
  protected final String TEXT_41 = ".append(\"|\");";
  protected final String TEXT_42 = NL + "\t";
  protected final String TEXT_43 = "       " + NL + "    int nb_line_";
  protected final String TEXT_44 = " = 0;" + NL + "    int nb_success_";
  protected final String TEXT_45 = " = 0;" + NL + "    int nb_reject_";
  protected final String TEXT_46 = " = 0;" + NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\torg.talend.salesforce.SforceConnection sforceConn_";
  protected final String TEXT_47 = " = null;";
  protected final String TEXT_48 = NL + "        if(globalMap.get(\"conn_";
  protected final String TEXT_49 = "\") == null){" + NL + "\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_50 = "\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_51 = NL + "\t\tsforceConn_";
  protected final String TEXT_52 = " = (org.talend.salesforce.SforceConnection)globalMap.get(\"conn_";
  protected final String TEXT_53 = "\"); \t" + NL + "\t";
  protected final String TEXT_54 = NL + "    \t\t";
  protected final String TEXT_55 = NL + "        \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_56 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_57 = ");" + NL + "        \t";
  protected final String TEXT_58 = NL + "        \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ";" + NL + "        \t";
  protected final String TEXT_61 = NL + "\t\t\tsforceConn_";
  protected final String TEXT_62 = " = " + NL + "    \t\t\tnew org.talend.salesforce.SforceOAuthConnection.Builder(";
  protected final String TEXT_63 = ", ";
  protected final String TEXT_64 = ", decryptedQauthClientPwd_";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ")" + NL + "    \t\t\t\t";
  protected final String TEXT_69 = NL + "        \t\t\t\t.setTokenFilePath(";
  protected final String TEXT_70 = ")" + NL + "    \t\t\t\t";
  protected final String TEXT_71 = NL + "    \t\t\t\t.setTimeout(";
  protected final String TEXT_72 = ").needCompression(";
  protected final String TEXT_73 = ")" + NL + "                \t";
  protected final String TEXT_74 = NL + "                \t\t.setClientID(";
  protected final String TEXT_75 = ");" + NL + "                \t";
  protected final String TEXT_76 = NL + "                \t.build();" + NL + "\t\t";
  protected final String TEXT_77 = NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_78 = NL + NL + "\t\t\t";
  protected final String TEXT_79 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_80 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = "; ";
  protected final String TEXT_85 = NL + "\t\t" + NL + "\t\t\tsforceConn_";
  protected final String TEXT_86 = " = " + NL + "    \t\t\tnew org.talend.salesforce.SforceBasicConnection.Builder(";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ", decryptedPassword_";
  protected final String TEXT_89 = ")" + NL + "    \t\t\t\t.setTimeout(";
  protected final String TEXT_90 = ").needCompression(";
  protected final String TEXT_91 = ")" + NL + "                \t";
  protected final String TEXT_92 = NL + "                \t\t.setClientID(";
  protected final String TEXT_93 = ");" + NL + "                \t";
  protected final String TEXT_94 = NL + "                \t.build();" + NL + "    \t";
  protected final String TEXT_95 = NL + "    org.talend.salesforce.SforceManagement sforceManagement_";
  protected final String TEXT_96 = " = new org.talend.salesforce.SforceManagementImpl(sforceConn_";
  protected final String TEXT_97 = ", ";
  protected final String TEXT_98 = ", ";
  protected final String TEXT_99 = ", ";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "\t\torg.apache.axiom.om.OMFactory fac_";
  protected final String TEXT_102 = " = org.apache.axiom.om.OMAbstractFactory.getOMFactory();       ";
  protected final String TEXT_103 = NL + "\t";
  protected final String TEXT_104 = NL + "\t   \t\tclass SFDynamicUtils_";
  protected final String TEXT_105 = "{" + NL + "\t   \t\t\torg.apache.axiom.om.OMFactory omeFactory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();     " + NL + "\t   \t\t\tpublic void extractDynamicColumn(routines.system.Dynamic dynamic,java.util.List<org.apache.axiom.om.OMElement> list, java.util.List<String> nullList) throws Exception{" + NL + "\t   \t\t\t\tfor(int i=0;i<dynamic.getColumnCount();i++){" + NL + "\t   \t\t\t\t\troutines.system.DynamicMetadata dynamicMetadata = dynamic.getColumnMetadata(i);" + NL + "\t   \t\t\t\t\tString talendType = dynamicMetadata.getType();" + NL + "\t   \t\t\t\t\tString fieldName = dynamicMetadata.getName();" + NL + "\t   \t\t\t\t\tObject fieldValue = dynamic.getColumnValue(fieldName);" + NL + "\t   \t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\t\tif(dynamicMetadata.getRefFieldName()!=null && dynamicMetadata.getRefModuleName()!=null){" + NL + "\t\t\t\t\t\t\t\torg.apache.axiom.om.OMElement reference = omeFactory.createOMElement(dynamicMetadata.getRefFieldName(), null);" + NL + "\t\t\t\t\t\t\t\treference.addChild(org.talend.salesforce.SforceManagementUtil.newOMElement(\"type\",dynamicMetadata.getRefModuleName()));" + NL + "\t\t\t\t\t\t\t\tif (\"id_Date\".equals(talendType)) {" + NL + "\t\t\t\t\t\t\t\t\tif(fieldValue != null){" + NL + "\t\t\t\t\t\t\t\t\t\treference.addChild(org.talend.salesforce.SforceManagementUtil.newOMElement(fieldName,FormatterUtils.format_Date((java.util.Date)(fieldValue), dynamicMetadata.getFormat()) ));" + NL + "\t    \t\t\t\t\t\t\t\tlist.add(reference);" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t\t} else if(fieldValue != null && !\"\".equals(String.valueOf(fieldValue))) { " + NL + "\t\t\t\t\t\t\t\t\treference.addChild(org.talend.salesforce.SforceManagementUtil.newOMElement(fieldName,String.valueOf(fieldValue) ));" + NL + "\t\t\t\t\t\t\t\t\tlist.add(reference);" + NL + "\t\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t\t\tif(\"Id\".equals(fieldName)){" + NL + "\t\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\t\tif (\"id_Date\".equals(talendType)) {" + NL + "\t\t\t\t\t\t\t\tif(fieldValue != null){" + NL + "\t\t\t\t\t\t\t\t\tlist.add(org.talend.salesforce.SforceManagementUtil.newOMElement(fieldName,FormatterUtils.format_Date((java.util.Date)(fieldValue), dynamicMetadata.getFormat()) ));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t} else if(fieldValue != null && !\"\".equals(String.valueOf(fieldValue))) { " + NL + "\t\t\t\t\t\t\t\tlist.add(org.talend.salesforce.SforceManagementUtil.newOMElement(fieldName,String.valueOf(fieldValue) ));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t    \t\t\t\t\tif(\"Id\".equals(fieldName)){" + NL + "\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif (\"id_Date\".equals(talendType)) {" + NL + "\t\t\t\t\t\t\t\tif(fieldValue != null){" + NL + "\t\t\t\t\t\t\t\t\tlist.add(org.talend.salesforce.SforceManagementUtil.newOMElement(fieldName,FormatterUtils.format_Date((java.util.Date)(fieldValue), dynamicMetadata.getFormat()) ));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t} else if(fieldValue != null && !\"\".equals(String.valueOf(fieldValue))) { " + NL + "\t\t\t\t\t\t\t\tlist.add(org.talend.salesforce.SforceManagementUtil.newOMElement(fieldName,String.valueOf(fieldValue) ));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t    \t\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\t\t\t\tif(fieldValue == null || \"\".equals(String.valueOf(fieldValue))){" + NL + "\t\t\t\t\t\t\t\t\tnullList.add(fieldName);" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_111 = NL + "\t    \t\t\t\t";
  protected final String TEXT_112 = NL + "\t   \t\t\t\t}" + NL + "\t   \t\t\t}" + NL + "\t   \t\t\t" + NL + "\t   \t\t}" + NL + "\t   \t\tSFDynamicUtils_";
  protected final String TEXT_113 = " sfDynamicUtils_";
  protected final String TEXT_114 = " =new SFDynamicUtils_";
  protected final String TEXT_115 = "();" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
            }
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        info(str("Start to work."));
    }
    
    public void endWork(){
        info(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_18);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_19);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_22);
    
                }   
                
    stringBuffer.append(TEXT_23);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_24);
    
            }
        }
        debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_26);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_27);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
                }else{
                
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_39);
    
                }
                
    stringBuffer.append(TEXT_40);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_41);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    stringBuffer.append(TEXT_42);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    	
	log = new LogUtil(node);
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

	String username = ElementParameterParser.getValue(node, "__USER__");

	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String commitLevel = ElementParameterParser.getValue(node, "__COMMIT_LEVEL__");
	boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));
	String logFile = ElementParameterParser.getValue(node, "__LOGFILENAME__").trim();
	boolean ceaseForError = ("true").equals(ElementParameterParser.getValue(node, "__CEASE_FOR_ERROR__"));
	boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
	String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");
	// if the extended insert is disabled set the commit level to 1
	if (!extendedInsert) commitLevel = "1";
	
	String passwordFieldName = "";
	
	boolean bulkConnection = false; //for tSalesforceOAuth.javajet
	
	String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
	String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
	boolean useOAuth = "OAUTH".equals(loginType);
	
	String upsertkey = ElementParameterParser.getValue(node, "__UPSERT_KEY_COLUMN__");
	boolean ignoreNullValue = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_NULL__"));
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
    if(useExistingConn){
    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_50);
    log.info(log.str("Use exist connection : " + connection + "."));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_53);
    
	}else{
		if(useOAuth){
			String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
    		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
    		
    stringBuffer.append(TEXT_54);
    
        	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
        	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
        	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_57);
    
        	} else {
        	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    
        	}
        	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
    		
    		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
    		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_68);
    
    				if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
    				
    stringBuffer.append(TEXT_69);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_70);
    
    				}
    				
    stringBuffer.append(TEXT_71);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_73);
    
                	if(clientID != null && !"".equals(clientID) && !"\"\"".equals(clientID)){
                	
    stringBuffer.append(TEXT_74);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_75);
    
                	}
                	
    stringBuffer.append(TEXT_76);
    
		}else{
		
    stringBuffer.append(TEXT_77);
    
			passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_78);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_81);
    } else {
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_91);
    
                	if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
                	
    stringBuffer.append(TEXT_92);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_93);
    
                	}
                	
    stringBuffer.append(TEXT_94);
    
    	}
    	log.info(log.str("Login successful."));
    }
    
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(commitLevel);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ceaseForError);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(logFile);
    stringBuffer.append(TEXT_100);
    if("upsert".equals(action)){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//A1
	    IMetadataTable metadata = metadatas.get(0);
	    boolean hasDynamic = metadata.isDynamicSchema();
	    if(hasDynamic){
	   	
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
	   					if("upsert".equals(action)) {
						
    stringBuffer.append(TEXT_106);
    
							if("Id".equals(upsertkey)){
							
    stringBuffer.append(TEXT_107);
    
							}
							
    stringBuffer.append(TEXT_108);
    
	    				}else{
	    				
    stringBuffer.append(TEXT_109);
    
							if(!ignoreNullValue){
							
    stringBuffer.append(TEXT_110);
    
							}
							
    stringBuffer.append(TEXT_111);
    
	    				}
	   					
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
		}
	}
	
    return stringBuffer.toString();
  }
}
