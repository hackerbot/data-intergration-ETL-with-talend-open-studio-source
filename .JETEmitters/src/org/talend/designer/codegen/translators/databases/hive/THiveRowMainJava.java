package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class THiveRowMainJava
{
  protected static String nl;
  public static synchronized THiveRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowMainJava result = new THiveRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tquery_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\tbw_";
  protected final String TEXT_5 = ".write(query_";
  protected final String TEXT_6 = " + \";\");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_7 = "_QUERY\", query_";
  protected final String TEXT_8 = ");" + NL + "\t" + NL + "\tbw_";
  protected final String TEXT_9 = ".close();" + NL + "" + NL + "\tif(libjars_";
  protected final String TEXT_10 = ".length() > 0) {" + NL + "\t\tinstance_";
  protected final String TEXT_11 = ".setLibJars(libjars_";
  protected final String TEXT_12 = ".toString().substring(0, libjars_";
  protected final String TEXT_13 = ".length()-1));" + NL + "\t}" + NL + "\tinstance_";
  protected final String TEXT_14 = ".sendFiles();" + NL + "\tinstance_";
  protected final String TEXT_15 = ".callWS(null, true);" + NL + "\tint exitCode_";
  protected final String TEXT_16 = " = instance_";
  protected final String TEXT_17 = ".execute();" + NL + "\tif(exitCode_";
  protected final String TEXT_18 = " > 0) {" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\tthrow new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_20 = NL + "\t\t\tSystem.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_22 = " - \" + e.getMessage());";
  protected final String TEXT_23 = NL + "\t}";
  protected final String TEXT_24 = "    " + NL + "\t\t\t";
  protected final String TEXT_25 = " = null;            " + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\tquery_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "\twhetherReject_";
  protected final String TEXT_29 = " = false;" + NL + "" + NL + "\t";
  protected final String TEXT_30 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_31 = "_QUERY\",query_";
  protected final String TEXT_32 = ");" + NL + "\t";
  protected final String TEXT_33 = NL + "\t\tjava.sql.ResultSet rs_";
  protected final String TEXT_34 = " = null;" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\ttry {" + NL + "\t";
  protected final String TEXT_36 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_37 = ".setTimestamp(";
  protected final String TEXT_38 = ",new java.sql.Timestamp(";
  protected final String TEXT_39 = ".getTime()));" + NL + "\t";
  protected final String TEXT_40 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_41 = ".set";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = ",";
  protected final String TEXT_44 = ");" + NL + "\t";
  protected final String TEXT_45 = NL + "\t\t\trs_";
  protected final String TEXT_46 = " = pstmt_";
  protected final String TEXT_47 = ".executeQuery();" + NL + "\t";
  protected final String TEXT_48 = NL + "\t    \tpstmt_";
  protected final String TEXT_49 = ".execute();" + NL + "\t    \t";
  protected final String TEXT_50 = NL + "\t\t\trs_";
  protected final String TEXT_51 = " = stmt_";
  protected final String TEXT_52 = ".executeQuery(query_";
  protected final String TEXT_53 = ");" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t    \tstmt_";
  protected final String TEXT_55 = ".execute(query_";
  protected final String TEXT_56 = ");" + NL + "\t    \t";
  protected final String TEXT_57 = NL + "\t    } catch (java.lang.Exception e) {" + NL + "\t        whetherReject_";
  protected final String TEXT_58 = " = true;" + NL + "\t        ";
  protected final String TEXT_59 = NL + "\t            throw(e);" + NL + "\t            ";
  protected final String TEXT_60 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_61 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_62 = NL + "\t                ";
  protected final String TEXT_63 = " = new ";
  protected final String TEXT_64 = "Struct();" + NL + "\t                ";
  protected final String TEXT_65 = NL + "\t\t                    ";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ";" + NL + "\t\t                    ";
  protected final String TEXT_70 = NL + "\t                ";
  protected final String TEXT_71 = ".errorCode = ((java.sql.SQLException)e).getSQLState();" + NL + "\t                ";
  protected final String TEXT_72 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_73 = ";" + NL + "\t                ";
  protected final String TEXT_74 = NL + "\t                System.err.print(e.getMessage());" + NL + "\t                ";
  protected final String TEXT_75 = NL + "\t    }" + NL + "\t\t";
  protected final String TEXT_76 = NL + "\t    if(!whetherReject_";
  protected final String TEXT_77 = ") {" + NL + "\t        ";
  protected final String TEXT_78 = NL + "\t                    ";
  protected final String TEXT_79 = " = new ";
  protected final String TEXT_80 = "Struct();" + NL + "\t                    ";
  protected final String TEXT_81 = NL + "\t                    \t    ";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = rs_";
  protected final String TEXT_84 = ";" + NL + "\t                    \t    ";
  protected final String TEXT_85 = NL + "\t                    \t    ";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = ";" + NL + "\t                    \t    ";
  protected final String TEXT_90 = NL + "\t    }" + NL + "\t    ";
  protected final String TEXT_91 = NL + "\t        commitCounter_";
  protected final String TEXT_92 = "++;" + NL + "\t        if(commitEvery_";
  protected final String TEXT_93 = " <= commitCounter_";
  protected final String TEXT_94 = ") {" + NL + "\t        " + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_96 = " - Starting to commit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_97 = NL + "\t        \tconn_";
  protected final String TEXT_98 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_100 = " - Commit has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_101 = NL + "\t        \t" + NL + "\t        \tcommitCounter_";
  protected final String TEXT_102 = "=0;" + NL + "\t        \t" + NL + "\t        }" + NL + "\t        ";
  protected final String TEXT_103 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String cid =  node.getUniqueName();
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String commitEvery = "0";//ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
String propagateRecordset = ElementParameterParser.getValue(node,"__PROPAGATE_RECORD_SET__");
String recordsetColumn = ElementParameterParser.getValue(node,"__RECORD_SET_COLUMN__");

boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);

boolean isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
	isExecutedThroughWebHCat = false;
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
		if(connection!=null && connection.equals(pNode.getUniqueName())) {
			isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(pNode, "__DISTRIBUTION__"));
		}
	}
}

if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
		if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_19);
    
		} else {

    stringBuffer.append(TEXT_20);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
			}
		}

    stringBuffer.append(TEXT_23);
    
} else {
	List<Map<String, String>> prepareStatementParameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SET_PREPAREDSTATEMENT_PARAMETERS__");  
	
	String incomingConnName = null;
	
	Set<String> inputCols = new HashSet<String>();
	
	List<IMetadataColumn> columnList = null;
	
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
	    IConnection rejectConn = rejectConns.get(0);
	    rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumnList = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
	    rejectColumnList = metadataTable.getListColumns();      
	}
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	
	boolean hasOutgoingDataConnection = false;
	for(IConnection conn : outgoingConns) {
	    if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			if(!hasOutgoingDataConnection){
				hasOutgoingDataConnection = true;
			}
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
          
	    }
	}
	
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns = node.getIncomingConnections();
			columnList = metadata.getListColumns();
			if(conns != null && conns.size()>0){
				IConnection conn = conns.get(0);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					incomingConnName = conn.getName();
					IMetadataTable inputMetadataTable = conn.getMetadataTable();
					for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
						inputCols.add(inputCol.getLabel());
					}
				}
			}//end of connection size.
		}//end of metadatas
	}
	if(!hasOutgoingDataConnection || columnList == null || columnList.size() < 1){
		propagateRecordset = "false";
	}
	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	if(("true").equals(propagateRecordset)) {
	    
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
	}
	
    stringBuffer.append(TEXT_35);
    		
		if (usePrepareStatement) {
		
			for (Map<String, String> param : prepareStatementParameters) {
				
				if ("Date".equals(param.get("PARAMETER_TYPE"))) {
	
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(param.get("PARAMETER_INDEX"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(param.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_39);
    
				} else {
	
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(param.get("PARAMETER_TYPE"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(param.get("PARAMETER_INDEX"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(param.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_44);
    
				}
			}
			
			if(("true").equals(propagateRecordset)){
	
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
			} else {
	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
			}
			
		} else {
			if(("true").equals(propagateRecordset)){
	
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
		} else {
		    
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
			}
		}
	    
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
	        if (("true").equals(dieOnError)) {
	            
    stringBuffer.append(TEXT_59);
    
	        } else {
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    }
	            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
	                
    stringBuffer.append(TEXT_62);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_64);
    
	                if(incomingConnName!=null){
		                for(IMetadataColumn column : columnList) {
		                	if (inputCols.contains(column.getLabel())) {
		                    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    
		                    }
		                }
	                }
	                
    stringBuffer.append(TEXT_70);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_73);
    
	            } else {
	                
    stringBuffer.append(TEXT_74);
    
	            }
	        } 
	        
    stringBuffer.append(TEXT_75);
    
		
	if(outgoingConns != null && outgoingConns.size() > 0) {
	    
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
	        for(IConnection outgoingConn : outgoingConns) {
	            if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
	                if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	                    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_80);
    
	                    for(IMetadataColumn column : columnList) {
	                    	if(("true").equals(propagateRecordset) && column.getLabel().equals(recordsetColumn)){
	                    	    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
	                    	} else {
	                    		if(incomingConnName!=null){
	                    			if (inputCols.contains(column.getLabel())) {
	                    	    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    
	                    	    	}
	                    	    }
	              			}
	                    }
	                }
	            }
	        }
	        
    stringBuffer.append(TEXT_90);
    
	}	
		
	if(!("true").equals(useExistingConn)) {
		if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
	        
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
		}
	}
}

    stringBuffer.append(TEXT_103);
    return stringBuffer.toString();
  }
}
