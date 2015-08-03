package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMomInputLoopEndJava
{
  protected static String nl;
  public static synchronized TMomInputLoopEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputLoopEndJava result = new TMomInputLoopEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\tmessage_";
  protected final String TEXT_3 = ".acknowledge();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_6 = " - Sleepping time(";
  protected final String TEXT_7 = "s)...\");" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tThread.sleep(";
  protected final String TEXT_9 = "*1000);" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tbreak;" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tif (session_";
  protected final String TEXT_13 = " != null && connection_";
  protected final String TEXT_14 = " != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Committing the session...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\tsession_";
  protected final String TEXT_18 = ".commit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Commit successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t}" + NL + "\t\t\t}catch(java.lang.Exception ex){" + NL + "\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_23 = " - A Active MQ error occurred :\" + ex);" + NL + "\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tSystem.out.println(\"A Active MQ error occurred :\" + ex);" + NL + "\t\t      \tex.printStackTrace();" + NL + "\t\t\t\tif (session_";
  protected final String TEXT_25 = " != null  && connection_";
  protected final String TEXT_26 = " != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Rollback operations...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\tsession_";
  protected final String TEXT_30 = ".rollback();" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Rollback successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_34 = NL + "        " + NL + "\t\t}" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_37 = ".backout();" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t" + NL + "\t\t}catch(com.ibm.mq.MQException ex){" + NL + "\t\t\tSystem.out.println(\"A WebSphere MQ error occurred : Completion code \" + ex.completionCode + \" Reason code \" + ex.reasonCode);" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_39 = NL + NL + "} finally {" + NL + "\t";
  protected final String TEXT_40 = NL + "\t\tif(consumer_";
  protected final String TEXT_41 = "!=null){" + NL + "\t\t\tconsumer_";
  protected final String TEXT_42 = ".close();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_45 = " - Closing connection...\");" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tif (session_";
  protected final String TEXT_48 = " != null  && connection_";
  protected final String TEXT_49 = " != null) {" + NL + "\t \t\t\tsession_";
  protected final String TEXT_50 = ".close();" + NL + " \t\t \t}" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t" + NL + "\t        if (connection_";
  protected final String TEXT_52 = " != null) {" + NL + "\t         \tconnection_";
  protected final String TEXT_53 = ".close();" + NL + "\t        }" + NL + "\t        " + NL + "\t        ";
  protected final String TEXT_54 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_55 = " - Closed successfully\");" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_57 = NL + "\t" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\tlog.info(\"";
  protected final String TEXT_59 = " - Closing connection...\");" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t" + NL + "\t\tSystem.out.println(\"Closing connection\");" + NL + "\t\t" + NL + "\t\tif(consumer_";
  protected final String TEXT_61 = "!=null) {" + NL + "        \tconsumer_";
  protected final String TEXT_62 = ".close();" + NL + "        }" + NL + "        " + NL + "        if(session_";
  protected final String TEXT_63 = "!=null) {" + NL + "        \tsession_";
  protected final String TEXT_64 = ".close();" + NL + "        }" + NL + "        " + NL + "        if(connection_";
  protected final String TEXT_65 = "!=null) {" + NL + "    \t\tconnection_";
  protected final String TEXT_66 = ".close();" + NL + "        }" + NL + "        ";
  protected final String TEXT_67 = NL + "\t\tlog.info(\"";
  protected final String TEXT_68 = " - Closed successfully.\");" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\t" + NL + "\t";
  protected final String TEXT_70 = NL + "\t\tlog.info(\"";
  protected final String TEXT_71 = " - Disconnecting connection...\");" + NL + "\t\t";
  protected final String TEXT_72 = NL + "\t\t" + NL + "\t\tSystem.out.println(\"Disconnecting queue...\");" + NL + "\t\t" + NL + "\t\tif(remoteQ_";
  protected final String TEXT_73 = "!=null) {" + NL + "\t\t\tremoteQ_";
  protected final String TEXT_74 = ".close();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\tif(backoutQueue_";
  protected final String TEXT_76 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_78 = " - Closing backout queue...\");" + NL + "\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\tbackoutQueue_";
  protected final String TEXT_80 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_82 = " - Closed successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_84 = NL + "\t\t\tSystem.out.println(\"Disconnecting queue manager...\");" + NL + "\t\t\tif(qMgr_";
  protected final String TEXT_85 = "!=null) {" + NL + "\t\t\t\tqMgr_";
  protected final String TEXT_86 = ".disconnect();" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_87 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_88 = " - Disconnected successfully.\");" + NL + "\t\t";
  protected final String TEXT_89 = NL + "}" + NL;
  protected final String TEXT_90 = NL + "\tlog.info(\"";
  protected final String TEXT_91 = " - Consumed messages count: \"+ nb_line_";
  protected final String TEXT_92 = " + \" .\");";
  protected final String TEXT_93 = NL + NL + "\tglobalMap.put(\"";
  protected final String TEXT_94 = "_NB_LINE\",nb_line_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
	String timeOut=ElementParameterParser.getValue(node, "__TIMEOUT__");
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));	
    String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");
    
    List<? extends INode> commitNodes=node.getProcess().getNodesOfType("tMomCommit");
    List<? extends INode> rollBackNodes=node.getProcess().getNodesOfType("tMomRollback");

    boolean isCommitRollback = false;
    for(INode cNode:commitNodes){
    	String cNodeName = ElementParameterParser.getValue(cNode,"__CONNECTION__");
    	if(cid.equals(cNodeName) || (isUseExistConnection && connectionComponentName.equals(cNodeName))){
    		isCommitRollback = true;
    		break;
    	}
    }
    if(!isCommitRollback){
    	for(INode rNode:rollBackNodes){
    		String rNodeName = ElementParameterParser.getValue(rNode,"__CONNECTION__");
    		if(cid.equals(rNodeName) || (isUseExistConnection && connectionComponentName.equals(rNodeName))){
    			isCommitRollback = true;
    			break;
    		}
    	}
    }
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 

    if (isUseExistConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
			}	
		}
	}
	
	if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {
		if ("CLIENT_ACKNOWLEDGE".equals(acknowledgmentMode)) {
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
		}
		if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
		
    stringBuffer.append(TEXT_4);
    
		}
		if(("JBoss").equals(serverType)){
			if("true".equals(kListen)){
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(timeOut);
    stringBuffer.append(TEXT_7);
    
				}
				
    stringBuffer.append(TEXT_8);
    stringBuffer.append(timeOut);
    stringBuffer.append(TEXT_9);
    		
			}else{
			
    stringBuffer.append(TEXT_10);
    			
			}
		}else if(("ActiveMQ").equals(serverType)) {
			if (("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"))) {
			
    stringBuffer.append(TEXT_11);
    
			}
		}
		
        if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
					}
					
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
					}
					
    stringBuffer.append(TEXT_21);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
				}
				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
					}
					
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
					}
					
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    
	}else{//websphere
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		isRollback = isRollback && ("false".equals(kListen)) && !isCommit && !isBrowse;
		boolean isAutoBackout = ("true").equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
		isAutoBackout = isAutoBackout && !isBrowse && !isRollback && !isCommit && (!("true").equals(kListen));
		
    stringBuffer.append(TEXT_35);
    
			if(isRollback || isAutoBackout){
			
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
			}
			
    stringBuffer.append(TEXT_38);
    
	}
	
    stringBuffer.append(TEXT_39);
    if("ActiveMQ".equals(serverType)){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
		if(!isUseExistConnection) {
		
    stringBuffer.append(TEXT_43);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
			if(!isCommitRollback) {
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
			}
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    
		}
	} else if("JBoss".equals(serverType)){
    stringBuffer.append(TEXT_57);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    } else {//websphere
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		isRollback = isRollback && ("false".equals(kListen)) && !isCommit && !isBrowse;
		boolean isAutoBackout = "true".equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
		isAutoBackout = isAutoBackout && !isBrowse && !isRollback && !isCommit && (!("true").equals(kListen));
		
		if (!isUseExistConnection && isLog4jEnabled && !isCommitRollback) {
		
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
		}
		
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
		if(isAutoBackout){
		
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    
		}
		
		if(!isUseExistConnection && !isCommitRollback){
		
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
		}
		
		if (!isUseExistConnection && isLog4jEnabled && !isCommitRollback) {
		
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
		}
	}
	
    stringBuffer.append(TEXT_89);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(TEXT_96);
    return stringBuffer.toString();
  }
}
