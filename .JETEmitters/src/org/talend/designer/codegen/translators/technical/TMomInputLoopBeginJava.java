package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomInputLoopBeginJava
{
  protected static String nl;
  public static synchronized TMomInputLoopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputLoopBeginJava result = new TMomInputLoopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\tjavax.jms.Connection connection_";
  protected final String TEXT_4 = " = null;" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_6 = " = null;" + NL + "\t\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_7 = " = null;";
  protected final String TEXT_8 = NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_9 = "=null;" + NL + "\t\tcom.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_10 = "=null;";
  protected final String TEXT_11 = NL + "\t\tcom.ibm.mq.MQQueue  backoutQueue_";
  protected final String TEXT_12 = " = null;";
  protected final String TEXT_13 = NL + "\t" + NL + "\ttry {" + NL;
  protected final String TEXT_14 = NL + "            try {" + NL + "\t            ";
  protected final String TEXT_15 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Get a connection from component: ";
  protected final String TEXT_17 = " .\");" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t        connection_";
  protected final String TEXT_19 = " = (javax.jms.Connection) globalMap.get(\"connection_";
  protected final String TEXT_20 = "\");" + NL + "\t\t        ";
  protected final String TEXT_21 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_22 = " - Activating the connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t            connection_";
  protected final String TEXT_24 = ".start();" + NL + "\t            ";
  protected final String TEXT_25 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_26 = " - Activate successfully.\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Get a  session from component: ";
  protected final String TEXT_28 = " .\");" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tsession_";
  protected final String TEXT_30 = " = (javax.jms.Session) globalMap.get(\"session_";
  protected final String TEXT_31 = "\");" + NL + "\t\t    } catch (NullPointerException npe) {" + NL + "\t\t    \t";
  protected final String TEXT_32 = "\t" + NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_33 = " - Got connection unsuccessfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t    \tthrow new RuntimeException(\"";
  protected final String TEXT_35 = " still not initialized. Try to redesign job.\");" + NL + "\t\t    }" + NL + "\t    \tjavax.jms.Destination des_";
  protected final String TEXT_36 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\tdes_";
  protected final String TEXT_38 = " = session_";
  protected final String TEXT_39 = ".createQueue(";
  protected final String TEXT_40 = ");" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t    \tdes_";
  protected final String TEXT_42 = " = session_";
  protected final String TEXT_43 = ".createTopic(";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + NL + "\t\t\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_46 = " = session_";
  protected final String TEXT_47 = ".createProducer(null);" + NL + "\t\t\treplyProducer_";
  protected final String TEXT_48 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\tconsumer_";
  protected final String TEXT_49 = " = session_";
  protected final String TEXT_50 = ".createConsumer(des_";
  protected final String TEXT_51 = ");" + NL + "\t" + NL + "\t\t\tglobalMap.put(\"session_";
  protected final String TEXT_52 = "\",session_";
  protected final String TEXT_53 = ");" + NL + "\t\t\tglobalMap.put(\"connection_";
  protected final String TEXT_54 = "\",connection_";
  protected final String TEXT_55 = ");" + NL + "\t\t" + NL + "\t\t\t// Receive message" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_57 = ";" + NL + "\t\t\t\twhile ((message_";
  protected final String TEXT_58 = " = consumer_";
  protected final String TEXT_59 = ".receive()) != null) {" + NL + "" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t        \ttry {   // For rollback" + NL + "\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tint maxMsg_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL + "\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_65 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_66 = " = 0; i_";
  protected final String TEXT_67 = " < maxMsg_";
  protected final String TEXT_68 = " ;) {" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t        \ttry {   // For rollback" + NL + "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t/*npruss start: changes for static discovery and custom connection parameters and timeout in max message operation*/" + NL + "\t\t\t        javax.jms.Message message_";
  protected final String TEXT_71 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_73 = " = consumer_";
  protected final String TEXT_74 = ".receive(";
  protected final String TEXT_75 = "*1000);" + NL + "\t\t\t\t\t\tif(message_";
  protected final String TEXT_76 = " == null){" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\ti_";
  protected final String TEXT_77 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_79 = " = consumer_";
  protected final String TEXT_80 = ".receive();" + NL + "\t\t\t\t\t\tif(message_";
  protected final String TEXT_81 = " != null) {" + NL + "\t\t\t\t\t\t\ti_";
  protected final String TEXT_82 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t/*npruss end: changes for static discovery and custom connection parameters and timeout in max message operation*/" + NL + "\t\t\t\t" + NL + "\t\t\t        //javax.jms.Message message_";
  protected final String TEXT_84 = " = consumer_";
  protected final String TEXT_85 = ".receive();" + NL + "\t\t\t        if (message_";
  protected final String TEXT_86 = " != null) {" + NL + "\t\t            \ti_";
  protected final String TEXT_87 = "++;" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t    System.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_89 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t    javax.jms.Message message_";
  protected final String TEXT_90 = ";" + NL + "\t\t\t    while ((message_";
  protected final String TEXT_91 = " = consumer_";
  protected final String TEXT_92 = ".receive(";
  protected final String TEXT_93 = "*1000)) != null) {" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t        \ttry {   // For rollback" + NL + "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t    " + NL + "\t\t\t/*-----------------------------------------------------------4.judge message body type---------------------------------------*/" + NL + "\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t\tif (message_";
  protected final String TEXT_98 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\t\tjavax.jms.MapMessage txtMsg_";
  protected final String TEXT_99 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_100 = ";" + NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_101 = " = txtMsg_";
  protected final String TEXT_102 = ".getString(";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t\tif(msg_";
  protected final String TEXT_104 = " !=null){" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\tjavax.jms.TextMessage txtMsg_";
  protected final String TEXT_106 = " = (javax.jms.TextMessage) message_";
  protected final String TEXT_107 = ";" + NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_108 = " = txtMsg_";
  protected final String TEXT_109 = ".getText();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\tjavax.jms.BytesMessage bytesMsg_";
  protected final String TEXT_111 = " = (javax.jms.BytesMessage) message_";
  protected final String TEXT_112 = ";" + NL + "\t\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_113 = " = new byte[(int)bytesMsg_";
  protected final String TEXT_114 = ".getBodyLength()];" + NL + "\t\t\t\t\tbytesMsg_";
  protected final String TEXT_115 = ".readBytes(bytesMsgBody_";
  protected final String TEXT_116 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_118 = " = new String(bytesMsgBody_";
  protected final String TEXT_119 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\tjavax.jms.MapMessage  msg_";
  protected final String TEXT_121 = "  = (javax.jms.MapMessage) message_";
  protected final String TEXT_122 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_123 = NL + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\tjava.util.Hashtable props_";
  protected final String TEXT_125 = "=new java.util.Hashtable();" + NL + "\t\t\t\tprops_";
  protected final String TEXT_126 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_127 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_128 = "+\":\"+";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_130 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_131 = ".put(javax.naming.Context.URL_PKG_PREFIXES, \"org.jboss.naming\");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_132 = ".put(\"java.naming.factory.url.pkgs\",\"org.jboss.naming:org.jnp.interfaces\");\t" + NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.naming.Context context_";
  protected final String TEXT_133 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_134 = ");" + NL + "\t\t\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_135 = "=(javax.jms.ConnectionFactory)context_";
  protected final String TEXT_136 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_138 = " =\"\";" + NL + "\t      \t\tString endParam_";
  protected final String TEXT_139 = "=\"\";" + NL + " \t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_141 = " = \"failover:(\";" + NL + "\t\t\t\t\tendParam_";
  protected final String TEXT_142 = "=";
  protected final String TEXT_143 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_145 = " = \"discovery://static:(\";" + NL + "\t\t\t\t\tendParam_";
  protected final String TEXT_146 = "=";
  protected final String TEXT_147 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_149 = " = url_";
  protected final String TEXT_150 = " +\",\";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_152 = " = url_";
  protected final String TEXT_153 = " +\"";
  protected final String TEXT_154 = "://\";" + NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_155 = " = url_";
  protected final String TEXT_156 = " +";
  protected final String TEXT_157 = ";" + NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_158 = " = url_";
  protected final String TEXT_159 = " +\":\";" + NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_160 = " = url_";
  protected final String TEXT_161 = " +";
  protected final String TEXT_162 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_164 = " = url_";
  protected final String TEXT_165 = " +\")\"+endParam_";
  protected final String TEXT_166 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_168 = " = url_";
  protected final String TEXT_169 = " +\"&\"+";
  protected final String TEXT_170 = "+\"=\"+";
  protected final String TEXT_171 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_173 = " = \"";
  protected final String TEXT_174 = "://\"+";
  protected final String TEXT_175 = "+\":\"+";
  protected final String TEXT_176 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_177 = "\t\t\t" + NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\torg.apache.activemq.broker.BrokerService broker_";
  protected final String TEXT_179 = " = new org.apache.activemq.broker.BrokerService();" + NL + "\t\t\t\t\tbroker_";
  protected final String TEXT_180 = ".setUseJmx(true);" + NL + "\t\t\t\t\tbroker_";
  protected final String TEXT_181 = ".addConnector(url_";
  protected final String TEXT_182 = ");" + NL + "\t\t\t\t\tbroker_";
  protected final String TEXT_183 = ".start();" + NL + "\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_185 = ");" + NL + "\t\t\t\tSystem.out.println(\"Consuming \" + (";
  protected final String TEXT_186 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_188 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_189 = " - Attempt to create connection from URL: \" + url_";
  protected final String TEXT_190 = " + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_192 = " = new org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_193 = ");" + NL + "\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\tconnection_";
  protected final String TEXT_195 = " = factory_";
  protected final String TEXT_196 = ".createConnection();" + NL + "\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_198 = NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_199 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_200 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_201 = ");";
  protected final String TEXT_202 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_203 = " = ";
  protected final String TEXT_204 = "; ";
  protected final String TEXT_205 = NL + "\t\t\t" + NL + "\t\t\t\tconnection_";
  protected final String TEXT_206 = " = factory_";
  protected final String TEXT_207 = ".createConnection(";
  protected final String TEXT_208 = ",decryptedPassword_";
  protected final String TEXT_209 = ");" + NL + "\t\t\t";
  protected final String TEXT_210 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_211 = " - Created connection successfully.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_212 = " - Activating the connection...\");" + NL + "\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\tconnection_";
  protected final String TEXT_214 = ".start();" + NL + "\t\t\t";
  protected final String TEXT_215 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_216 = " - Activate successfully.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_217 = " - Creating a session...\");" + NL + "\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\tsession_";
  protected final String TEXT_219 = " = connection_";
  protected final String TEXT_220 = ".createSession(";
  protected final String TEXT_221 = ", javax.jms.Session.";
  protected final String TEXT_222 = ");" + NL + "\t\t\t";
  protected final String TEXT_223 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_224 = " - Created session successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_225 = NL + "\t\t\tjavax.jms.Destination des_";
  protected final String TEXT_226 = " = null;" + NL + "\t" + NL + "\t" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\tdes_";
  protected final String TEXT_228 = " = session_";
  protected final String TEXT_229 = ".createQueue(";
  protected final String TEXT_230 = ");" + NL + "\t\t\t";
  protected final String TEXT_231 = NL + "\t\t    \tdes_";
  protected final String TEXT_232 = " = session_";
  protected final String TEXT_233 = ".createTopic(";
  protected final String TEXT_234 = ");" + NL + "\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_236 = " = session_";
  protected final String TEXT_237 = ".createProducer(null);" + NL + "\t\t\treplyProducer_";
  protected final String TEXT_238 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\t\t" + NL + "\t\t\tconsumer_";
  protected final String TEXT_239 = " = session_";
  protected final String TEXT_240 = ".createConsumer(des_";
  protected final String TEXT_241 = ");" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\tglobalMap.put(\"session_";
  protected final String TEXT_243 = "\",session_";
  protected final String TEXT_244 = ");" + NL + "\t\t\t\tglobalMap.put(\"connection_";
  protected final String TEXT_245 = "\",connection_";
  protected final String TEXT_246 = ");" + NL + "\t       \t";
  protected final String TEXT_247 = NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_248 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_249 = " - Ready to receive message.\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_250 = " - Waiting...\");" + NL + "\t\t\t\t";
  protected final String TEXT_251 = "\t\t\t\t\t" + NL + "\t\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_252 = ";" + NL + "\t\t\t" + NL + "\t\t\t\twhile((message_";
  protected final String TEXT_253 = "=consumer_";
  protected final String TEXT_254 = ".receive())!=null){" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_255 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_256 = " - Listening to receive messages...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_257 = NL + "\t\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_258 = ";" + NL + "\t\t\t\t\twhile ((message_";
  protected final String TEXT_259 = " = consumer_";
  protected final String TEXT_260 = ".receive()) != null) {" + NL + "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_261 = NL + "\t\t\t        \ttry {   // For rollback" + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\t";
  protected final String TEXT_263 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_264 = " - Listening to receive messages...\");" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_265 = " - Consume max message number:  \" + ";
  protected final String TEXT_266 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_267 = NL + "\t\t\t\t\tint maxMsg_";
  protected final String TEXT_268 = " = ";
  protected final String TEXT_269 = ";" + NL + "\t\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_270 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\t\tfor (int i_";
  protected final String TEXT_271 = " = 0; i_";
  protected final String TEXT_272 = " < maxMsg_";
  protected final String TEXT_273 = " ;) {" + NL + "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_274 = NL + "\t\t\t        \ttry {   // For rollback" + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_275 = NL + "\t\t\t\t        javax.jms.Message message_";
  protected final String TEXT_276 = " = consumer_";
  protected final String TEXT_277 = ".receive();" + NL + "\t\t\t\t        if (message_";
  protected final String TEXT_278 = " != null) {" + NL + "\t\t\t            \ti_";
  protected final String TEXT_279 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_280 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_281 = " - Listening to receive messages...\");" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_282 = " - Listening time last for:  \" + ";
  protected final String TEXT_283 = "*1000 + \" ms, and then stop.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_284 = NL + "\t\t\t\t    System.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_285 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t\t    javax.jms.Message message_";
  protected final String TEXT_286 = ";" + NL + "\t\t\t\t    while ((message_";
  protected final String TEXT_287 = " = consumer_";
  protected final String TEXT_288 = ".receive(";
  protected final String TEXT_289 = "*1000)) != null) {" + NL + "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_290 = NL + "\t\t\t        \ttry {   // For rollback" + NL + "\t\t\t\t\t";
  protected final String TEXT_291 = NL + "\t\t\t\t";
  protected final String TEXT_292 = NL + "\t\t\t\tif (message_";
  protected final String TEXT_293 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\t\tjavax.jms.MapMessage txtMsg_";
  protected final String TEXT_294 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_295 = ";" + NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_296 = " = txtMsg_";
  protected final String TEXT_297 = ".getString(";
  protected final String TEXT_298 = ");" + NL + "\t\t\t\t\tif(msg_";
  protected final String TEXT_299 = " !=null){" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_300 = NL + "\t\t\t\t\tjavax.jms.TextMessage txtMsg_";
  protected final String TEXT_301 = " = (javax.jms.TextMessage) message_";
  protected final String TEXT_302 = ";" + NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_303 = " = txtMsg_";
  protected final String TEXT_304 = ".getText();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_305 = NL + "\t\t\t\t\tjavax.jms.BytesMessage bytesMsg_";
  protected final String TEXT_306 = " = (javax.jms.BytesMessage) message_";
  protected final String TEXT_307 = ";" + NL + "\t\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_308 = " = new byte[(int)bytesMsg_";
  protected final String TEXT_309 = ".getBodyLength()];" + NL + "\t\t\t\t\tbytesMsg_";
  protected final String TEXT_310 = ".readBytes(bytesMsgBody_";
  protected final String TEXT_311 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_313 = " = new String(bytesMsgBody_";
  protected final String TEXT_314 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_315 = NL + "\t\t\t\t\tjavax.jms.MapMessage  msg_";
  protected final String TEXT_316 = "  = (javax.jms.MapMessage) message_";
  protected final String TEXT_317 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_318 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_319 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_320 = " = (com.ibm.mq.MQQueueManager)globalMap.get(\"qMgr_";
  protected final String TEXT_321 = "\");" + NL + "\t\t\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_322 = "\",qMgr_";
  protected final String TEXT_323 = ");" + NL + "\t\t\t";
  protected final String TEXT_324 = NL + "\t\t\t\tjava.util.Hashtable properties";
  protected final String TEXT_325 = "=new java.util.Hashtable();" + NL + "\t\t\t\tproperties";
  protected final String TEXT_326 = ".put(\"hostname\", ";
  protected final String TEXT_327 = ");" + NL + "\t\t\t\tproperties";
  protected final String TEXT_328 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_329 = "));" + NL + "\t\t\t\tproperties";
  protected final String TEXT_330 = ".put(\"channel\", ";
  protected final String TEXT_331 = ");" + NL + "\t\t\t\tproperties";
  protected final String TEXT_332 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\t\t\tproperties";
  protected final String TEXT_333 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t\t\t";
  protected final String TEXT_334 = NL + "\t\t\t\t\tcom.ibm.mq.MQEnvironment.sslCipherSuite = \"";
  protected final String TEXT_335 = "\";" + NL + "\t\t\t\t";
  protected final String TEXT_336 = NL + "\t\t\t\t\tproperties";
  protected final String TEXT_337 = ".put(\"userID\",";
  protected final String TEXT_338 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_339 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_340 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_341 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_342 = ");";
  protected final String TEXT_343 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_344 = " = ";
  protected final String TEXT_345 = "; ";
  protected final String TEXT_346 = NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t\t\tproperties";
  protected final String TEXT_347 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_348 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_349 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_350 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_351 = ",properties";
  protected final String TEXT_352 = ");" + NL + "\t\t\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_353 = "\",qMgr_";
  protected final String TEXT_354 = ");" + NL + "\t\t\t";
  protected final String TEXT_355 = NL + "\t\t\t\tString msgId_";
  protected final String TEXT_356 = " = ";
  protected final String TEXT_357 = ";" + NL + "\t\t    \tif (msgId_";
  protected final String TEXT_358 = " != null & !(\"\").equals(msgId_";
  protected final String TEXT_359 = ")) {" + NL + "\t\t\t\t\tString padding_";
  protected final String TEXT_360 = " = new String();" + NL + "\t\t\t       \tint padlen_";
  protected final String TEXT_361 = " = 24;" + NL + "\t\t\t " + NL + "\t\t\t       \tint len_";
  protected final String TEXT_362 = " = Math.abs(padlen_";
  protected final String TEXT_363 = ") - msgId_";
  protected final String TEXT_364 = ".toString().length();" + NL + "\t\t\t       \tif (len_";
  protected final String TEXT_365 = " > 0) {" + NL + "\t\t\t        \tfor (int i = 0 ; i < len_";
  protected final String TEXT_366 = " ; i++) {" + NL + "\t\t\t           \t\tpadding_";
  protected final String TEXT_367 = " = padding_";
  protected final String TEXT_368 = " + \" \";" + NL + "\t\t\t         \t}" + NL + "\t\t\t        \tmsgId_";
  protected final String TEXT_369 = " = msgId_";
  protected final String TEXT_370 = " + padding_";
  protected final String TEXT_371 = ";" + NL + "\t\t\t        }" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_372 = NL + "\t\t\ttry{" + NL + "\t" + NL + "\t\t\t\tint openOptions";
  protected final String TEXT_373 = "=com.ibm.mq.MQC.MQOO_INPUT_SHARED | com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INQUIRE";
  protected final String TEXT_374 = " | com.ibm.mq.MQC.MQOO_BROWSE";
  protected final String TEXT_375 = ";" + NL + "\t\t\t" + NL + "\t\t\t\tcom.ibm.mq.MQGetMessageOptions gmo";
  protected final String TEXT_376 = "=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t\t\t\t";
  protected final String TEXT_377 = NL + "\t\t\t\t\tgmo";
  protected final String TEXT_378 = ".options=gmo";
  protected final String TEXT_379 = ".options+com.ibm.mq.MQC.MQGMO_BROWSE_FIRST;" + NL + "\t\t\t\t\tint browseCursor_";
  protected final String TEXT_380 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_381 = NL + "\t\t\t\t\tgmo";
  protected final String TEXT_382 = ".options=gmo";
  protected final String TEXT_383 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t\t\t\t";
  protected final String TEXT_384 = NL + "\t\t\t\tgmo";
  protected final String TEXT_385 = ".options=gmo";
  protected final String TEXT_386 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_387 = "MQGMO_NO_WAIT";
  protected final String TEXT_388 = "MQGMO_WAIT";
  protected final String TEXT_389 = ";" + NL + "\t\t\t\tgmo";
  protected final String TEXT_390 = ".options=gmo";
  protected final String TEXT_391 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\tgmo";
  protected final String TEXT_392 = ".waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t\t\t\tcom.ibm.mq.MQException.log = null;" + NL + "\t\t\t\tboolean flag";
  protected final String TEXT_393 = "=true;" + NL + "\t\t\t" + NL + "\t\t\t\tremoteQ_";
  protected final String TEXT_394 = "=qMgr_";
  protected final String TEXT_395 = ".accessQueue(";
  protected final String TEXT_396 = ",openOptions";
  protected final String TEXT_397 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_398 = NL + "\t\t\t\t\tint[] selectors_";
  protected final String TEXT_399 = " = new int[2];" + NL + "\t\t\t\t\tint[] intAttrs_";
  protected final String TEXT_400 = " = new int[1];" + NL + "\t\t\t\t\tint threshold_";
  protected final String TEXT_401 = " = 0;" + NL + "\t\t\t\t\tString backoutQName_";
  protected final String TEXT_402 = " = \"\";" + NL + "\t\t\t\t\tbyte[] charAttrs_";
  protected final String TEXT_403 = " = new byte[com.ibm.mq.MQC.MQ_Q_NAME_LENGTH];" + NL + "\t\t\t\t\tselectors_";
  protected final String TEXT_404 = "[0] = com.ibm.mq.MQC.MQCA_BACKOUT_REQ_Q_NAME;" + NL + "\t\t\t\t\tselectors_";
  protected final String TEXT_405 = "[1] = com.ibm.mq.MQC.MQIA_BACKOUT_THRESHOLD;" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_406 = "\t" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_407 = " - Initing backout queue ...\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_408 = NL + "\t\t\t\t\t\tremoteQ_";
  protected final String TEXT_409 = ".inquire(selectors_";
  protected final String TEXT_410 = ", intAttrs_";
  protected final String TEXT_411 = ", charAttrs_";
  protected final String TEXT_412 = ");" + NL + "\t\t\t\t\t\tthreshold_";
  protected final String TEXT_413 = " = intAttrs_";
  protected final String TEXT_414 = "[0];" + NL + "\t\t\t\t\t\tbackoutQName_";
  protected final String TEXT_415 = " = new String(charAttrs_";
  protected final String TEXT_416 = ");" + NL + "\t\t\t\t\t\tif(threshold_";
  protected final String TEXT_417 = " > 0 && backoutQName_";
  protected final String TEXT_418 = ".trim().length()>0){" + NL + "\t\t\t\t\t\t\tbackoutQueue_";
  protected final String TEXT_419 = " = qMgr_";
  protected final String TEXT_420 = ".accessQueue(backoutQName_";
  protected final String TEXT_421 = ", 16);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tthrow new java.lang.Exception(\"Init backout queue unsuccessfully!\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_422 = "\t" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_423 = " - The backout queue of \"+";
  protected final String TEXT_424 = "+\" is:\"+backoutQName_";
  protected final String TEXT_425 = ");" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_426 = " - The threshold value of messages in \"+";
  protected final String TEXT_427 = "+\" is:\"+threshold_";
  protected final String TEXT_428 = ");" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_429 = " - Init backout queue successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_430 = NL + "\t\t\t\t\t}catch (java.lang.Exception e_";
  protected final String TEXT_431 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_432 = "\t" + NL + "\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_433 = " - Init backout queue unsuccessfully, poison messages will remain on the input queue.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_434 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"Init backout queue unsuccessfully, poison messages will remain on the input queue.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_435 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_436 = NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_437 = NL + "\t\t\t\tif(Integer.valueOf(remoteQ_";
  protected final String TEXT_438 = ".getCurrentDepth()).equals(0))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tflag";
  protected final String TEXT_439 = "= false;" + NL + "\t\t\t\t} \t" + NL + "\t\t\t";
  protected final String TEXT_440 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_441 = " - Ready to receive message.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_442 = " - Waiting...\");" + NL + "\t\t\t";
  protected final String TEXT_443 = "\t" + NL + "\t\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\t\twhile(flag";
  protected final String TEXT_444 = "){" + NL + "\t\t\t";
  protected final String TEXT_445 = NL + "\t\t\t\tif(Integer.valueOf(remoteQ_";
  protected final String TEXT_446 = ".getCurrentDepth()).equals(1))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tflag";
  protected final String TEXT_447 = "= false;" + NL + "\t\t\t\t} \t\t\t" + NL + "\t\t\t";
  protected final String TEXT_448 = NL + "\t\t\t\tif(browseCursor_";
  protected final String TEXT_449 = " > 0){" + NL + "\t\t\t\t\tgmo";
  protected final String TEXT_450 = ".options=com.ibm.mq.MQC.MQGMO_BROWSE_NEXT; " + NL + "\t\t\t\t\tgmo";
  protected final String TEXT_451 = ".options=gmo";
  protected final String TEXT_452 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_453 = "MQGMO_NO_WAIT";
  protected final String TEXT_454 = "MQGMO_WAIT";
  protected final String TEXT_455 = ";" + NL + "\t\t\t\t\tgmo";
  protected final String TEXT_456 = ".options=gmo";
  protected final String TEXT_457 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbrowseCursor_";
  protected final String TEXT_458 = "++;" + NL + "\t\t\t";
  protected final String TEXT_459 = NL + "\t\t\tcom.ibm.mq.MQMessage inMessage";
  protected final String TEXT_460 = "=new com.ibm.mq.MQMessage();" + NL + "\t\t\t";
  protected final String TEXT_461 = NL + "\t\t\t\tinMessage";
  protected final String TEXT_462 = ".messageId = msgId_";
  protected final String TEXT_463 = ".getBytes(\"ISO-8859-15\");" + NL + "\t\t\t";
  protected final String TEXT_464 = "\t\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tremoteQ_";
  protected final String TEXT_465 = ".get(inMessage";
  protected final String TEXT_466 = ",gmo";
  protected final String TEXT_467 = ");" + NL + "\t\t\t\t}catch (com.ibm.mq.MQException me_";
  protected final String TEXT_468 = ") {   " + NL + "\t\t            if (me_";
  protected final String TEXT_469 = ".reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t            \tbreak;   " + NL + "\t\t            }else{" + NL + "\t\t            \tthrow me_";
  protected final String TEXT_470 = ";" + NL + "\t\t            }   " + NL + "     \t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_471 = NL + "\t\t\t\tremoteQ_";
  protected final String TEXT_472 = ".get(inMessage";
  protected final String TEXT_473 = ",gmo";
  protected final String TEXT_474 = ");" + NL + "\t\t\t";
  protected final String TEXT_475 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_476 = "\t\t\t\t" + NL + "\t\t\torg.talend.mq.headers.rfh2.MQRFH2 mqrfh2_";
  protected final String TEXT_477 = " = new org.talend.mq.headers.rfh2.MQRFH2(inMessage";
  protected final String TEXT_478 = ");" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_479 = NL + NL + "\t\t\t";
  protected final String TEXT_480 = NL + "\t    \t\tString msg_";
  protected final String TEXT_481 = "=inMessage";
  protected final String TEXT_482 = ".readStringOfByteLength(inMessage";
  protected final String TEXT_483 = ".getDataLength());" + NL + "\t\t\t";
  protected final String TEXT_484 = NL + "\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_485 = " = new byte[inMessage";
  protected final String TEXT_486 = ".getDataLength()];" + NL + "\t\t\t\tinMessage";
  protected final String TEXT_487 = ".readFully(bytesMsgBody_";
  protected final String TEXT_488 = ");" + NL + "\t\t\t";
  protected final String TEXT_489 = NL + "\t\t\t\tString msg_";
  protected final String TEXT_490 = " = new String(bytesMsgBody_";
  protected final String TEXT_491 = ");" + NL + "\t\t\t";
  protected final String TEXT_492 = NL + "\t\t\t\tjava.util.Map msg_";
  protected final String TEXT_493 = " = (java.util.Map)inMessage";
  protected final String TEXT_494 = ".readObject();\t\t\t  " + NL + "\t\t\t";
  protected final String TEXT_495 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_496 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_497 = NL + "\t\t\t\tif (backoutQueue_";
  protected final String TEXT_498 = "!=null && threshold_";
  protected final String TEXT_499 = " > 0 && inMessage";
  protected final String TEXT_500 = ".backoutCount >= threshold_";
  protected final String TEXT_501 = "-1) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_502 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_503 = " - Moving backout message to backout queue...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_504 = NL + "\t\t\t\t\tbackoutQueue_";
  protected final String TEXT_505 = ".put(inMessage";
  protected final String TEXT_506 = ");" + NL + "\t\t\t\t\tqMgr_";
  protected final String TEXT_507 = ".commit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_508 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_509 = " - Moved successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_510 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_511 = NL + NL + NL + "\t\t";
  protected final String TEXT_512 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
    boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
    String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	String msgId=ElementParameterParser.getValue(node, "__MSG_ID__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String from=ElementParameterParser.getValue(node, "__FROM__");
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	
	boolean staticdiscovery =  ("true").equals(ElementParameterParser.getValue(node, "__STATIC__"));
	String connectParamFailover = ElementParameterParser.getValue(node, "__CONNECTION_PARAM_FAILOVER__");
	String connectParamStatic = ElementParameterParser.getValue(node, "__CONNECTION_PARAM_STATIC__");
	boolean useMaxTimeout = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX_WITH_TIMEOUT__"));
	
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
	List<Map<String,String>> additionalOpts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_OPTIONS__");
	
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	boolean isUseSSL = ("true").equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
	String transProtocol="tcp";
	if(isUseSSL){
		transProtocol = "ssl";
	}

	String strHost = null;
	String strPort = null;
	
	boolean useMqHeader = "true".equals(ElementParameterParser.getValue(node, "__USE_MQ_HEADER__"));

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
    	
    if (isUseExistConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType = ElementParameterParser.getValue(pNode, "__SERVER__");
                failover =  ("true").equals(ElementParameterParser.getValue(pNode, "__FAILOVER__"));
			}	
		}
	}

	IMetadataTable metadata=null;
	List<IMetadataColumn> columns = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		columns = metadata.getListColumns();
	} 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	if("ActiveMQ".equals(serverType) || "JBoss".equals(serverType)){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
	} else {//websphere

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		boolean isAutoBackout = ("true").equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
		
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		
		isCommit = isCommit && !isBrowse;
		isBrowse = isBrowse && !isRollback && !isCommit;
		isAutoBackout = isAutoBackout && !isBrowse && !isRollback && !isCommit && (!("true").equals(kListen));
		
		if(isAutoBackout){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		}
	}

    stringBuffer.append(TEXT_13);
     if (isUseExistConnection && ("ActiveMQ").equals(serverType)) { 
    stringBuffer.append(TEXT_14);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_17);
    
				}
				
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_20);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
				}
				
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_28);
    
				}
				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_31);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
				}
				
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
			if (("Queue").equals(msgType)) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_40);
    
			} else {
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_44);
    
			}
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
     boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
			String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
			String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
			if(("true").equals(kListen)){
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_60);
    
				}
				
    stringBuffer.append(TEXT_61);
    
			}else if (useMax) {
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_69);
    
				}
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    if(useMaxTimeout){
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    }else{
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
			}else {
			
    stringBuffer.append(TEXT_88);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_93);
    if(("ActiveMQ").equals(serverType) /*&& !isUseExistConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_94);
    
				}
				
    stringBuffer.append(TEXT_95);
    
			} 
    stringBuffer.append(TEXT_96);
    
			if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
			
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
			}else{
				if ("Text".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
				} else if ("Bytes".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
				    if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
				    }
				} else if ("Map".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
				}
			}
			
    stringBuffer.append(TEXT_123);
    } else if (("JBoss").equals(serverType)||(!isUseExistConnection && ("ActiveMQ").equals(serverType))) {
	
			/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
			if(("JBoss").equals(serverType) ){ // server judgement
			
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    		
			}else if(("ActiveMQ").equals(serverType)){
				boolean startServer = ("true").equals(ElementParameterParser.getValue(node, "__STARTSERVER__"));
				
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    if(failover || staticdiscovery){
      			if(failover){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(connectParamFailover);
    stringBuffer.append(TEXT_143);
    }else if(staticdiscovery){
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(connectParamStatic);
    stringBuffer.append(TEXT_147);
    }
					int i=0;
					for(Map<String, String> serversMap : servers) {
						strHost = serversMap.get("SERVERS_HOST");
						strPort = serversMap.get("SERVERS_PORT");
	
						if(i>0) {
						
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
						}
						
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_162);
    
						i++;
					}
					
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    
					for(Map<String, String> optrion : additionalOpts) {
					
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(optrion.get("OPTION_NAME"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(optrion.get("OPTION_VALUE"));
    stringBuffer.append(TEXT_171);
    
					}
				}else{
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    
				if(startServer){
				
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    
				}
				
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append("Topic".equals(msgType));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_187);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    
				}
				
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    
			}
			
			/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 
			
			if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) {
			
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    
			} else {
			
    stringBuffer.append(TEXT_197);
    
				String passwordFieldName = "__PASS__";
				
    stringBuffer.append(TEXT_198);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_201);
    } else {
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
			}
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
			}
			
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
			}
			
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_222);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    
			}
			
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    
			if (("Queue").equals(msgType)) {
			
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_230);
    
			} else {
			
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_234);
    
			}
			
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    	//put session to global map
			if( ("ActiveMQ").equals(serverType)) {
			
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    
			}
			
    stringBuffer.append(TEXT_247);
    		
			/*---------------------------------------3.recevice message form server ---------------------------------*/ 	
			if(("JBoss").equals(serverType) ){ 
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
				}
				
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    		
			}else if(("ActiveMQ").equals(serverType)){
				boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
				String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
				String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
				if(("true").equals(kListen)){
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    
					}
					
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    if(("ActiveMQ").equals(serverType) /*&& !isUseExistConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_261);
    
					}
					
    stringBuffer.append(TEXT_262);
    
				}else if (useMax) {
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_266);
    
					}
					
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_274);
    
					}
					
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    
				}else {
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_283);
    
					}
					
    stringBuffer.append(TEXT_284);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_289);
    if(("ActiveMQ").equals(serverType) /*&& !isUseExistConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_290);
    
					}
					
    stringBuffer.append(TEXT_291);
    
				}
			}
			/*-----------------------------------------------------------4.judge message body type---------------------------------------*/
			if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
			
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    
			}else{
				if ("Text".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
				} else if ("Bytes".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    
				    if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
				    }
				} else if ("Map".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    
				}
			}
			
    stringBuffer.append(TEXT_318);
    
		} else if(("WebSphere").equals(serverType)){ //server judgement   /***WebSphere MQ*****/
			if(isUseExistConnection){
				String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    
			}else{
				String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
				String qm=ElementParameterParser.getValue(node, "__QM__");
				boolean needSSLCipher = ("true").equals(ElementParameterParser.getValue(node,"__SET_MQ_SSL_CIPHER__"));
				String sslCipher = ElementParameterParser.getValue(node, "__MQ_SSL_CIPHER__");
				
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
				if(needSSLCipher){
				
    stringBuffer.append(TEXT_334);
    stringBuffer.append(sslCipher);
    stringBuffer.append(TEXT_335);
    
				}
				if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
				
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_338);
    
					String passwordFieldName = "__PASS__";
					
    stringBuffer.append(TEXT_339);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_342);
    } else {
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
				}
				
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    
			}
			String queue = ElementParameterParser.getValue(node, "__QUEUE__");
			boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
			boolean isAutoBackout = ("true").equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
			
			boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
			boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
			
			isCommit = isCommit && !isBrowse;
			isBrowse = isBrowse && !isRollback && !isCommit;
			isAutoBackout = isAutoBackout && !isBrowse && !isRollback && !isCommit && (!("true").equals(kListen));
			
			if(("true").equals(useMsgId)){
			
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
			}
			
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    if(isBrowse){
    stringBuffer.append(TEXT_374);
    }
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    if(isBrowse){
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    }else{
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    }
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_387);
    }else{
    stringBuffer.append(TEXT_388);
    }
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
				if(isAutoBackout){
				
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    
						}
						
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
						}
						
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    
						}else{
						
    stringBuffer.append(TEXT_434);
    
						}
						
    stringBuffer.append(TEXT_435);
    
				}
				
    stringBuffer.append(TEXT_436);
    
			if(("false").equals(kListen)) {
			
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    
			}	
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    
			}
			
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    
			if(("false").equals(kListen)){
			
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    
			}
			if(isBrowse){
			
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_453);
    }else{
    stringBuffer.append(TEXT_454);
    }
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    
			}
			
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    
			if(("true").equals(useMsgId)&& !"Map".equals(msgBobyType)){
			
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    
			}
			if(("false").equals(kListen) && ("true").equals(useMsgId) && !"Map".equals(msgBobyType) ){
			
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    
			} else {
			
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    
			}
			
    stringBuffer.append(TEXT_475);
    
			if (useMqHeader) {
			
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    }
    stringBuffer.append(TEXT_479);
    		
			if ("Text".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    
			} else if ("Bytes".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    
		    	if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
			
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    
		    	}
			} else if ("Map".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    
			}
			if(isCommit){
			
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    
			}
			if(isAutoBackout){
			
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    
					}
					
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    
					}
					
    stringBuffer.append(TEXT_510);
    
			}
				
		}
		
    stringBuffer.append(TEXT_511);
    stringBuffer.append(TEXT_512);
    return stringBuffer.toString();
  }
}
