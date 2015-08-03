package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputMainJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputMainJava result = new TMicrosoftCrmOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                               nb_line_";
  protected final String TEXT_2 = " ++;" + NL + "                               java.util.Map<String, Object> map_";
  protected final String TEXT_3 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_4 = NL + "                                              map_";
  protected final String TEXT_5 = ".put(\"";
  protected final String TEXT_6 = "\", Long.valueOf(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "));";
  protected final String TEXT_9 = NL + "                                            map_";
  protected final String TEXT_10 = ".put(\"";
  protected final String TEXT_11 = "\", Boolean.valueOf(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = "));";
  protected final String TEXT_14 = NL + "                                            map_";
  protected final String TEXT_15 = ".put(\"";
  protected final String TEXT_16 = "\", (com.microsoft.schemas.xrm._2011.contracts.EntityCollection)";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "                                                                 if(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = " instanceof com.microsoft.schemas.xrm._2011.contracts.EntityReference){" + NL + "                                                                      map_";
  protected final String TEXT_22 = ".put(\"";
  protected final String TEXT_23 = "\", ";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ");" + NL + "                                                                 }else if(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = " instanceof routines.system.Document){" + NL + "                                                                      routines.system.Document document_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ";" + NL + "                                                                      org.dom4j.Document doc_";
  protected final String TEXT_31 = " = document_";
  protected final String TEXT_32 = ".getDocument();" + NL + "                                                                      com.microsoft.schemas.xrm._2011.contracts.EntityReference" + NL + "                                                                                    entityRef_";
  protected final String TEXT_33 = " = new com.microsoft.schemas.xrm._2011.contracts.EntityReference();" + NL + "                                                                      entityRef_";
  protected final String TEXT_34 = ".setId(" + NL + "                                                                                           new com.microsoft.schemas._2003._10.serialization.Guid()" + NL + "                                                                                               .setValue(" + NL + "                                                                                                         xmlHelper_";
  protected final String TEXT_35 = ".parseXml(doc_";
  protected final String TEXT_36 = ", \"//entity_reference/guid\")" + NL + "                                                                                                        )" + NL + "                                                                                                 );" + NL + "                                                                      entityRef_";
  protected final String TEXT_37 = ".setLogicalName(xmlHelper_";
  protected final String TEXT_38 = ".parseXml(doc_";
  protected final String TEXT_39 = ", \"//entity_reference/logical_name\"));" + NL + "                                                                      entityRef_";
  protected final String TEXT_40 = ".setName(xmlHelper_";
  protected final String TEXT_41 = ".parseXml(doc_";
  protected final String TEXT_42 = ", \"//entity_reference/name\"));" + NL + "                                                                      map_";
  protected final String TEXT_43 = ".put(\"";
  protected final String TEXT_44 = "\", entityRef_";
  protected final String TEXT_45 = ");" + NL + "                                                                 }else{" + NL + "                                                                      map_";
  protected final String TEXT_46 = ".put(\"";
  protected final String TEXT_47 = "\", null);" + NL + "                                                                 }";
  protected final String TEXT_48 = NL + "                                                                 routines.system.Document document_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ";" + NL + "                                                                 org.dom4j.Document doc_";
  protected final String TEXT_52 = " = document_";
  protected final String TEXT_53 = ".getDocument();" + NL + "                                                                 com.microsoft.schemas.xrm._2011.contracts.EntityReference" + NL + "                                                                               entityRef_";
  protected final String TEXT_54 = " = new com.microsoft.schemas.xrm._2011.contracts.EntityReference();" + NL + "                                                                 entityRef_";
  protected final String TEXT_55 = ".setId(" + NL + "                                                                                      new com.microsoft.schemas._2003._10.serialization.Guid()" + NL + "                                                                                          .setValue(" + NL + "                                                                                                    xmlHelper_";
  protected final String TEXT_56 = ".parseXml(doc_";
  protected final String TEXT_57 = ", \"//entity_reference/guid\")" + NL + "                                                                                                   )" + NL + "                                                                                            );" + NL + "                                                                 entityRef_";
  protected final String TEXT_58 = ".setLogicalName(xmlHelper_";
  protected final String TEXT_59 = ".parseXml(doc_";
  protected final String TEXT_60 = ", \"//entity_reference/logical_name\"));" + NL + "                                                                 entityRef_";
  protected final String TEXT_61 = ".setName(xmlHelper_";
  protected final String TEXT_62 = ".parseXml(doc_";
  protected final String TEXT_63 = ", \"//entity_reference/name\"));" + NL + "                                                                 map_";
  protected final String TEXT_64 = ".put(\"";
  protected final String TEXT_65 = "\", entityRef_";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "                                                                if(";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " instanceof java.util.Date){" + NL + "                                                                     map_";
  protected final String TEXT_70 = ".put(\"";
  protected final String TEXT_71 = "\", ";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = ");" + NL + "                                                                }else{" + NL + "                                                                     map_";
  protected final String TEXT_74 = ".put(\"";
  protected final String TEXT_75 = "\",ParserUtils.parseTo_Date(";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = ".toString(), ";
  protected final String TEXT_78 = "));" + NL + "                                                                }";
  protected final String TEXT_79 = NL + "                                                                     map_";
  protected final String TEXT_80 = ".put(\"";
  protected final String TEXT_81 = "\", ";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "                                                                     map_";
  protected final String TEXT_85 = ".put(\"";
  protected final String TEXT_86 = "\",ParserUtils.parseTo_Date(";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ".toString(), ";
  protected final String TEXT_89 = "));";
  protected final String TEXT_90 = NL + "                                                                if(";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " instanceof java.math.BigDecimal){" + NL + "                                                                   map_";
  protected final String TEXT_93 = ".put(\"";
  protected final String TEXT_94 = "\", ";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = ");" + NL + "                                                                }else{" + NL + "                                                                   map_";
  protected final String TEXT_97 = ".put(\"";
  protected final String TEXT_98 = "\"," + NL + "                                                                                     ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ".toString()));" + NL + "                                                                }";
  protected final String TEXT_101 = NL + "                                                                  map_";
  protected final String TEXT_102 = ".put(\"";
  protected final String TEXT_103 = "\", ";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "                                                                map_";
  protected final String TEXT_107 = ".put(\"";
  protected final String TEXT_108 = "\"," + NL + "                                                                                  ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = ".toString()));";
  protected final String TEXT_111 = NL + "                                              map_";
  protected final String TEXT_112 = ".put(\"";
  protected final String TEXT_113 = "\"," + NL + "                                                                Double.valueOf(";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = "));";
  protected final String TEXT_116 = NL + "                                              map_";
  protected final String TEXT_117 = ".put(\"";
  protected final String TEXT_118 = "\",";
  protected final String TEXT_119 = NL + "                                                                ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = ".toString());";
  protected final String TEXT_122 = NL + "                                              map_";
  protected final String TEXT_123 = ".put(\"";
  protected final String TEXT_124 = "\"," + NL + "                                                                Integer.valueOf(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = "));";
  protected final String TEXT_127 = NL + "                                              map_";
  protected final String TEXT_128 = ".put(\"";
  protected final String TEXT_129 = "\"," + NL + "                                                                new com.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty());";
  protected final String TEXT_130 = NL + "                                              com.microsoft.schemas.xrm._2011.contracts.Money" + NL + "                                                            money_";
  protected final String TEXT_131 = " = new com.microsoft.schemas.xrm._2011.contracts.Money();";
  protected final String TEXT_132 = NL + "                                                             if(";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " instanceof java.math.BigDecimal){" + NL + "                                                                            money_";
  protected final String TEXT_135 = ".setValue(";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = ");" + NL + "                                                             }else{" + NL + "                                                                            money_";
  protected final String TEXT_138 = ".setValue(ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_139 = NL + "                                                                                                         ";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = ".toString()" + NL + "                                                                                                         )" + NL + "                                                                                                     );" + NL + "                                                             }";
  protected final String TEXT_142 = NL + "                                                             money_";
  protected final String TEXT_143 = ".setValue(";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "                                                             money_";
  protected final String TEXT_147 = ".setValue(ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_148 = NL + "                                                                                          ";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = ".toString()" + NL + "                                                                                          )" + NL + "                                                                                      );";
  protected final String TEXT_151 = NL + "                                             map_";
  protected final String TEXT_152 = ".put(\"";
  protected final String TEXT_153 = "\", money_";
  protected final String TEXT_154 = ");";
  protected final String TEXT_155 = NL + "                                                 com.microsoft.schemas.xrm._2011.contracts.OptionSetValue" + NL + "                                                               optionSetValue_";
  protected final String TEXT_156 = " = new com.microsoft.schemas.xrm._2011.contracts.OptionSetValue();" + NL + "                                                 optionSetValue_";
  protected final String TEXT_157 = ".setValue(Integer.valueOf(";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = "));" + NL + "                                                 map_";
  protected final String TEXT_160 = ".put(\"";
  protected final String TEXT_161 = "\", optionSetValue_";
  protected final String TEXT_162 = ");";
  protected final String TEXT_163 = NL + "                                                 com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                               guid_";
  protected final String TEXT_164 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                 guid_";
  protected final String TEXT_165 = ".setValue(";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = ".toString());" + NL + "                                                 map_";
  protected final String TEXT_168 = ".put(\"";
  protected final String TEXT_169 = "\", guid_";
  protected final String TEXT_170 = ");";
  protected final String TEXT_171 = NL + "                                                  System.err.println(\"Unsupported Crm Data Type.\");" + NL + "                                                  map_";
  protected final String TEXT_172 = ".put(\"";
  protected final String TEXT_173 = "\", null);";
  protected final String TEXT_174 = NL + "                                      crmEntityHelper_";
  protected final String TEXT_175 = ".createEntity(\"";
  protected final String TEXT_176 = "\", map_";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + "                                      crmEntityHelper_";
  protected final String TEXT_179 = ".updateEntity(\"";
  protected final String TEXT_180 = "\", map_";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "                                crmEntityHelper_";
  protected final String TEXT_183 = ".deleteEntity(\"";
  protected final String TEXT_184 = "\",";
  protected final String TEXT_185 = ".Id);";
  protected final String TEXT_186 = NL + "                               System.out.println(\"Unsupported Operation.\");";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\tStringBuffer OperXml_";
  protected final String TEXT_188 = " = new StringBuffer();" + NL + "" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_189 = NL + "\t\t    \t\t\t\t\tOperXml_";
  protected final String TEXT_190 = ".append(\"<Create xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t    \t\t\t\t\tOperXml_";
  protected final String TEXT_192 = ".append(\"<Update xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\t\t        OperXml_";
  protected final String TEXT_194 = ".append(\"\\n\");" + NL + "\t\t\t\t\t    \tOperXml_";
  protected final String TEXT_195 = ".append(\"<entity xsi:type=\\\"web:\");" + NL + "\t\t\t\t\t    \tOperXml_";
  protected final String TEXT_196 = ".append(\"";
  protected final String TEXT_197 = "\");" + NL + "\t\t\t\t\t    \tOperXml_";
  protected final String TEXT_198 = ".append(\"\\\" xmlns:web=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "\t\t\t\t\t    \tOperXml_";
  protected final String TEXT_199 = ".append(\"\\n\");" + NL + "" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t    \t\t\t\t\tif(";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = " != null ) { //" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_204 = ".append(\"<\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_205 = ".append(\"";
  protected final String TEXT_206 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_208 = ".append(\" type=\\\"\");" + NL + "\t\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_209 = ".append(";
  protected final String TEXT_210 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_211 = ".append(\"\\\"\");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_213 = ".append(\">\");" + NL + "" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_214 = ".append(\"<![CDATA[\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_216 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = ", ";
  protected final String TEXT_219 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_221 = ".append(String.valueOf(";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_225 = ".append(\"]]>\");" + NL + "" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_226 = ".append(\"</\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_227 = ".append(\"";
  protected final String TEXT_228 = "\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_229 = ".append(\">\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_230 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_232 = ".append(\"<\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_233 = ".append(\"";
  protected final String TEXT_234 = "\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_235 = ".append(\"id>\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_236 = ".append(";
  protected final String TEXT_237 = ".Id);" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_238 = ".append(\"</\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_239 = ".append(\"";
  protected final String TEXT_240 = "\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_241 = ".append(\"id>\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_242 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t    \t\t\t\t\t} //" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_245 = ".append(\"</entity>\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_246 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_247 = ".append(\"</Create>\");" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2007.webservices.CreateDocument createDoc_";
  protected final String TEXT_248 = " =  com.microsoft.schemas.crm._2007.webservices.CreateDocument.Factory.parse(OperXml_";
  protected final String TEXT_249 = ".toString());" + NL + "\t\t\t\t\t\t\t\tservice_";
  protected final String TEXT_250 = ".create(createDoc_";
  protected final String TEXT_251 = ", catd_";
  protected final String TEXT_252 = ", null, null);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_253 = NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_254 = ".append(\"</entity>\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_255 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_256 = ".append(\"</Update>\");" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2007.webservices.UpdateDocument updateDoc_";
  protected final String TEXT_257 = " = com.microsoft.schemas.crm._2007.webservices.UpdateDocument.Factory.parse(OperXml_";
  protected final String TEXT_258 = ".toString());" + NL + "\t\t\t\t\t\t\t\tservice_";
  protected final String TEXT_259 = ".update(updateDoc_";
  protected final String TEXT_260 = ",catd_";
  protected final String TEXT_261 = ",null,null);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_263 = ".append(\"<Delete xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_264 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_265 = ".append(\"<entityName>\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_266 = ".append(\"";
  protected final String TEXT_267 = "\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_268 = ".append(\"</entityName>\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_269 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_270 = ".append(\"<id>\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_271 = ".append(";
  protected final String TEXT_272 = ".Id);" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_273 = ".append(\"</id>\\n\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_274 = ".append(\"</Delete>\");" + NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2007.webservices.DeleteDocument deleteDoc_";
  protected final String TEXT_275 = " = com.microsoft.schemas.crm._2007.webservices.DeleteDocument.Factory.parse(OperXml_";
  protected final String TEXT_276 = ".toString());" + NL + "\t\t\t\t\t\t\tservice_";
  protected final String TEXT_277 = ".delete(deleteDoc_";
  protected final String TEXT_278 = ",catd_";
  protected final String TEXT_279 = ",null,null);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_280 = NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute execute_";
  protected final String TEXT_281 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute.Factory" + NL + "\t\t\t\t\t\t            .newInstance();" + NL + "\t\t\t\t\t\t    com.microsoft.schemas.crm._2007.webservices.ExecuteDocument executeDoc_";
  protected final String TEXT_282 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory" + NL + "\t\t\t\t\t\t            .newInstance();" + NL + "\t\t\t\t\t\t    com.microsoft.schemas.crm._2007.webservices.AssignRequest assignRequest_";
  protected final String TEXT_283 = " = com.microsoft.schemas.crm._2007.webservices.AssignRequest.Factory" + NL + "\t\t\t\t\t\t            .newInstance();" + NL + "\t\t\t\t\t\t    com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipal assignee_";
  protected final String TEXT_284 = " = com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipal.Factory.newInstance();" + NL + "\t\t\t\t\t\t    assignee_";
  protected final String TEXT_285 = ".setPrincipalId(String.valueOf(";
  protected final String TEXT_286 = ".ownerid));" + NL + "\t\t\t\t\t\t    assignee_";
  protected final String TEXT_287 = ".setType(com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipalType.Enum.forString(\"User\"));" + NL + "\t\t\t\t\t\t    assignRequest_";
  protected final String TEXT_288 = ".setAssignee(assignee_";
  protected final String TEXT_289 = ");" + NL + "" + NL + "\t\t\t\t\t\t    com.microsoft.schemas.crm._2007.webservices.TargetOwnedDynamic dynamicTarget_";
  protected final String TEXT_290 = " = com.microsoft.schemas.crm._2007.webservices.TargetOwnedDynamic.Factory" + NL + "\t\t\t\t\t\t            .newInstance();" + NL + "\t\t\t\t\t\t    dynamicTarget_";
  protected final String TEXT_291 = ".setEntityName(\"";
  protected final String TEXT_292 = "\");" + NL + "\t\t\t\t\t\t    dynamicTarget_";
  protected final String TEXT_293 = ".setEntityId(String.valueOf(";
  protected final String TEXT_294 = ".Id));" + NL + "" + NL + "\t\t\t\t\t\t    assignRequest_";
  protected final String TEXT_295 = ".setTarget(dynamicTarget_";
  protected final String TEXT_296 = ");" + NL + "" + NL + "\t\t\t\t\t\t    execute_";
  protected final String TEXT_297 = ".setRequest(assignRequest_";
  protected final String TEXT_298 = ");" + NL + "\t\t\t\t\t\t    executeDoc_";
  protected final String TEXT_299 = ".setExecute(execute_";
  protected final String TEXT_300 = ");" + NL + "" + NL + "\t\t\t\t\t\t    executeDoc_";
  protected final String TEXT_301 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.parse(executeDoc_";
  protected final String TEXT_302 = ".toString());" + NL + "" + NL + "\t\t\t\t\t\t    service_";
  protected final String TEXT_303 = ".execute(executeDoc_";
  protected final String TEXT_304 = ", catd_";
  protected final String TEXT_305 = ", null,null);" + NL + "" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_306 = NL + "\t\t\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.Entity entity_";
  protected final String TEXT_308 = " = com.microsoft.schemas.xrm._2011.contracts.Entity.Factory.newInstance();" + NL + "\t\t\t\t\t\t\tentity_";
  protected final String TEXT_309 = ".setLogicalName(\"";
  protected final String TEXT_310 = "\");" + NL + "" + NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.AttributeCollection attributes_";
  protected final String TEXT_311 = " = com.microsoft.schemas.xrm._2011.contracts.AttributeCollection.Factory.newInstance();" + NL + "\t\t\t\t\t\t\torg.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType attribute_";
  protected final String TEXT_312 = " = null;" + NL + "" + NL + "\t\t\t\t\t\t\torg.apache.xmlbeans.XmlObject xmlObject_";
  protected final String TEXT_313 = " = null;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_314 = NL + "\t\t\t    \t\t\t\t\tif(";
  protected final String TEXT_315 = ".";
  protected final String TEXT_316 = " != null){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_317 = NL + "\t    \t\t\t\t\t\tattribute_";
  protected final String TEXT_318 = " = attributes_";
  protected final String TEXT_319 = ".addNewKeyValuePairOfstringanyType();" + NL + "\t    \t\t\t\t\t\tattribute_";
  protected final String TEXT_320 = ".setKey(\"";
  protected final String TEXT_321 = "\");" + NL + "\t\t    \t\t\t\t\t";
  protected final String TEXT_322 = NL + "\t\t\t\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_323 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t((com.microsoft.schemas.xrm._2011.contracts.EntityReference)xmlObject_";
  protected final String TEXT_324 = ").setId(";
  protected final String TEXT_325 = ".";
  protected final String TEXT_326 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t((com.microsoft.schemas.xrm._2011.contracts.EntityReference)xmlObject_";
  protected final String TEXT_327 = ").setLogicalName(";
  protected final String TEXT_328 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_329 = NL + "\t\t\t\t\t\t\t\t\t\"The type of column \"";
  protected final String TEXT_330 = "\" is EntityReference, need to specify the reference entity logical name in EntityReference Type Mapping table.\"" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_331 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_332 = " = com.microsoft.schemas.xrm._2011.contracts.OptionSetValue.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((com.microsoft.schemas.xrm._2011.contracts.OptionSetValue)xmlObject_";
  protected final String TEXT_333 = ").setValue(";
  protected final String TEXT_334 = ".";
  protected final String TEXT_335 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_336 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_337 = " = com.microsoft.schemas.xrm._2011.contracts.Money.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((com.microsoft.schemas.xrm._2011.contracts.Money)xmlObject_";
  protected final String TEXT_338 = ").setValue(";
  protected final String TEXT_339 = ".";
  protected final String TEXT_340 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_341 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_342 = " = com.microsoft.schemas._2003._10.serialization.Guid.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((com.microsoft.schemas._2003._10.serialization.Guid)xmlObject_";
  protected final String TEXT_343 = ").setStringValue(";
  protected final String TEXT_344 = ".";
  protected final String TEXT_345 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_346 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_347 = " = org.apache.xmlbeans.XmlString.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlString)xmlObject_";
  protected final String TEXT_348 = ").setStringValue(";
  protected final String TEXT_349 = ".";
  protected final String TEXT_350 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_351 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_352 = " = org.apache.xmlbeans.XmlDateTime.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlDateTime)xmlObject_";
  protected final String TEXT_353 = ").setDateValue(";
  protected final String TEXT_354 = ".";
  protected final String TEXT_355 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_356 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_357 = " = org.apache.xmlbeans.XmlBoolean.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlBoolean)xmlObject_";
  protected final String TEXT_358 = ").setBooleanValue(";
  protected final String TEXT_359 = ".";
  protected final String TEXT_360 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_361 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_362 = " = org.apache.xmlbeans.XmlDecimal.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlDecimal)xmlObject_";
  protected final String TEXT_363 = ").setBigDecimalValue(";
  protected final String TEXT_364 = ".";
  protected final String TEXT_365 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_366 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_367 = " = org.apache.xmlbeans.XmlInt.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlInt)xmlObject_";
  protected final String TEXT_368 = ").setIntValue(";
  protected final String TEXT_369 = ".";
  protected final String TEXT_370 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_371 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_372 = " = org.apache.xmlbeans.XmlLong.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlLong)xmlObject_";
  protected final String TEXT_373 = ").setLongValue(";
  protected final String TEXT_374 = ".";
  protected final String TEXT_375 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_376 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_377 = " = org.apache.xmlbeans.XmlDouble.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlDouble)xmlObject_";
  protected final String TEXT_378 = ").setDoubleValue(";
  protected final String TEXT_379 = ".";
  protected final String TEXT_380 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_381 = NL + "\t\t\t\t\t\t\t\t\t\"don't support entityCollection yet;\"" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_382 = NL + "\t\t\t\t\t\t\t\t\t\"don't support booleanManagedProperty yet;\"" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_383 = NL + "\t\t\t\t\t\t\t\t\t\"wrong type ";
  protected final String TEXT_384 = "\"" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_385 = NL + "\t\t\t\t\t\t\t\tattribute_";
  protected final String TEXT_386 = ".setValue(xmlObject_";
  protected final String TEXT_387 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_388 = NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_389 = NL + "\t\t\t\t\t\t\tentity_";
  protected final String TEXT_390 = ".setAttributes(attributes_";
  protected final String TEXT_391 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_392 = NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Create create_";
  protected final String TEXT_393 = " = com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Create.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\tcreate_";
  protected final String TEXT_394 = ".setEntity(entity_";
  protected final String TEXT_395 = ");" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.CreateDocument createDoc_";
  protected final String TEXT_396 = " = com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\tcreateDoc_";
  protected final String TEXT_397 = ".setCreate(create_";
  protected final String TEXT_398 = ");" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.CreateResponseDocument.CreateResponse createResp_";
  protected final String TEXT_399 = " = null;" + NL + "\t\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\t\tcreateResp_";
  protected final String TEXT_400 = " = serviceStub_";
  protected final String TEXT_401 = ".create(createDoc_";
  protected final String TEXT_402 = ").getCreateResponse();" + NL + "\t\t\t\t\t\t\t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Create_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_403 = "){" + NL + "\t\t\t\t\t\t\t\t\tthrow new Exception(ex_";
  protected final String TEXT_404 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t//String returnId_";
  protected final String TEXT_405 = " = createResp_";
  protected final String TEXT_406 = ".getCreateResult();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_407 = NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Update update_";
  protected final String TEXT_408 = " = com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Update.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\tupdate_";
  protected final String TEXT_409 = ".setEntity(entity_";
  protected final String TEXT_410 = ");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument updateDoc_";
  protected final String TEXT_411 = " = com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\tupdateDoc_";
  protected final String TEXT_412 = ".setUpdate(update_";
  protected final String TEXT_413 = ");" + NL + "\t\t\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\t\t\tserviceStub_";
  protected final String TEXT_414 = ".update(updateDoc_";
  protected final String TEXT_415 = ");" + NL + "\t\t\t\t\t\t\t\t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Update_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_416 = "){" + NL + "\t\t\t\t\t\t\t\t\t\tthrow new Exception(ex_";
  protected final String TEXT_417 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_418 = NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.OrganizationRequest request_";
  protected final String TEXT_419 = " = com.microsoft.schemas.xrm._2011.contracts.OrganizationRequest.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\trequest_";
  protected final String TEXT_420 = ".setNilRequestId();" + NL + "\t\t\t\t\t\t\t\t\trequest_";
  protected final String TEXT_421 = ".setRequestName(\"Assign\");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.ParameterCollection parameters_";
  protected final String TEXT_422 = " = com.microsoft.schemas.xrm._2011.contracts.ParameterCollection.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\torg.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType parameter_";
  protected final String TEXT_423 = " = null;" + NL + "" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_424 = " = parameters_";
  protected final String TEXT_425 = ".addNewKeyValuePairOfstringanyType();" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_426 = ".setKey(\"Target\");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.EntityReference targetEntity_";
  protected final String TEXT_427 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\ttargetEntity_";
  protected final String TEXT_428 = ".setId(";
  protected final String TEXT_429 = ".";
  protected final String TEXT_430 = ");" + NL + "\t\t\t\t\t\t\t\t\ttargetEntity_";
  protected final String TEXT_431 = ".setLogicalName(\"";
  protected final String TEXT_432 = "\");" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_433 = ".setValue(targetEntity_";
  protected final String TEXT_434 = ");" + NL + "" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_435 = " = parameters_";
  protected final String TEXT_436 = ".addNewKeyValuePairOfstringanyType();" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_437 = ".setKey(\"Assignee\");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.EntityReference assigneeEntity_";
  protected final String TEXT_438 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\tassigneeEntity_";
  protected final String TEXT_439 = ".setId(";
  protected final String TEXT_440 = ".";
  protected final String TEXT_441 = ");" + NL + "\t\t\t\t\t\t\t\t\tassigneeEntity_";
  protected final String TEXT_442 = ".setLogicalName(\"systemuser\");" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_443 = ".setValue(assigneeEntity_";
  protected final String TEXT_444 = ");" + NL + "" + NL + "\t\t\t\t\t\t\t\t\trequest_";
  protected final String TEXT_445 = ".setParameters(parameters_";
  protected final String TEXT_446 = ");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Execute execute_";
  protected final String TEXT_447 = " = com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Execute.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\texecute_";
  protected final String TEXT_448 = ".setRequest(request_";
  protected final String TEXT_449 = ");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument executeDoc_";
  protected final String TEXT_450 = " = com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\texecuteDoc_";
  protected final String TEXT_451 = ".setExecute(execute_";
  protected final String TEXT_452 = ");" + NL + "\t\t\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\t\t\tserviceStub_";
  protected final String TEXT_453 = ".execute(executeDoc_";
  protected final String TEXT_454 = ");" + NL + "\t\t\t\t\t\t\t\t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Execute_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_455 = "){" + NL + "\t\t\t\t\t\t\t\t\t\tthrow new Exception(ex_";
  protected final String TEXT_456 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_457 = NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Delete delete_";
  protected final String TEXT_458 = " = com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Delete.Factory.newInstance();" + NL + "\t\t\t\t\t\t\tdelete_";
  protected final String TEXT_459 = ".setEntityName(\"";
  protected final String TEXT_460 = "\");" + NL + "\t\t\t\t\t\t\tdelete_";
  protected final String TEXT_461 = ".setId(";
  protected final String TEXT_462 = ".Id);" + NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument deleteDoc_";
  protected final String TEXT_463 = " = com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Factory.newInstance();" + NL + "\t\t\t\t\t\t\tdeleteDoc_";
  protected final String TEXT_464 = ".setDelete(delete_";
  protected final String TEXT_465 = ");" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\tserviceStub_";
  protected final String TEXT_466 = ".delete(deleteDoc_";
  protected final String TEXT_467 = ");" + NL + "\t\t\t\t\t\t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Delete_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_468 = "){" + NL + "\t\t\t\t\t\t\t\tthrow new Exception(ex_";
  protected final String TEXT_469 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_470 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_471 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_472 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    String authenticationType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    String crmVersion = ElementParameterParser.getValue(node, "__MS_CRM_VERSION__");

    boolean isMsCrm2015OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2015".equals(crmVersion);

        if(isMsCrm2015OnPremise){
           
    
    String entityName = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
    String customEntityName = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
    if("CustomEntity".equals(entityName)){
        entityName = customEntityName.replaceAll("\"","");
    }
    entityName = entityName.toLowerCase();
    String action = ElementParameterParser.getValue(node,"__ACTION__");

    List<IMetadataTable> metadatas = node.getMetadataList();
    if((metadatas != null) && (metadatas.size() > 0)){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){
            List<? extends IConnection> conns = node.getIncomingConnections();
            for(IConnection conn : conns){
                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                    String connName = conn.getName();
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int columnSize = columns.size();

    
                        if("insert".equals(action) || "update".equals(action)){
                            
    stringBuffer.append(TEXT_1);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    
                            for(int i = 0; i < columnSize; i++){
                                String index = cid + "_" + i;
                                IMetadataColumn column = columns.get(i);
                                String columnName = column.getLabel();
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                String crmType = column.getType();
                                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            
    
                                       if("BIGINT".equals(crmType)){
                                           //Map 2 Java Long
                                           
    stringBuffer.append(TEXT_4);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_8);
    
                                       }else if("BOOLEAN".equals(crmType)){
                                            //Map 2 Java Boolean
                                            
    stringBuffer.append(TEXT_9);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    
                                       }else if("CALENDARRULES".equals(crmType) || "PARTYLIST".equals(crmType)){
                                            //Todo: Need to find a better solution.
                                            
    stringBuffer.append(TEXT_14);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_18);
    
                                       }else if("CUSTOMER".equals(crmType) || "LOOKUP".equals(crmType) || "OWNER".equals(crmType)){
                                            //Map 2 Java Document
                                            
    
                                                   if(javaType == JavaTypesManager.OBJECT){
                                                              
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_47);
    
                                                   }else{
                                                              
    stringBuffer.append(TEXT_48);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_66);
    
                                                   }
                                                
    
                                   }else if("DATETIME".equals(crmType)){
                                             
    
                                                  if(javaType == JavaTypesManager.OBJECT){
                                                             
    stringBuffer.append(TEXT_67);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_78);
    
                                                  }else if(javaType == JavaTypesManager.DATE){
                                                             
    stringBuffer.append(TEXT_79);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_83);
    
                                                  }else{
                                                             
    stringBuffer.append(TEXT_84);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_89);
    
                                                  }
                                                
    
                                  }else if("DECIMAL".equals(crmType)){
                                             //Map 2 Java BigDecimal
                                              
    
                                                if(javaType == JavaTypesManager.OBJECT){
                                                             
    stringBuffer.append(TEXT_90);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_100);
    
                                                }else if(javaType == JavaTypesManager.BIGDECIMAL){
                                                             
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_105);
    
                                                }else{
                                                             
    stringBuffer.append(TEXT_106);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_110);
    
                                                }
                                               
    
                                  }else if("DOUBLE".equals(crmType)){
                                              //Map 2 Java Double
                                              
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_115);
    
                                  }else if("ENTITYNAME".equals(crmType) || "MEMO".equals(crmType) || "STRING".equals(crmType)){
                                              //Map 2 Java String
                                              
    stringBuffer.append(TEXT_116);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_121);
    
                                  }else if("INTEGER".equals(crmType)){
                                              //Map 2 Java Integer
                                              
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_126);
    
                                  }else if("MANAGEDPROPERTY".equals(crmType)){
                                              //Map 2 Java Object
                                              
    stringBuffer.append(TEXT_127);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_129);
    
                                  }else if("MONEY".equals(crmType)){
                                              //Map to Java BigDecimal
                                              
    stringBuffer.append(TEXT_130);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_131);
    
                                               if(javaType == JavaTypesManager.OBJECT){
                                                          
    stringBuffer.append(TEXT_132);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_141);
    
                                               }else if(javaType == JavaTypesManager.BIGDECIMAL){
                                                          
    stringBuffer.append(TEXT_142);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_145);
    
                                               }else{
                                                          
    stringBuffer.append(TEXT_146);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_150);
    
                                               }
                                               
    stringBuffer.append(TEXT_151);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_154);
    
                                  }else if("PICKLIST".equals(crmType) || "STATE".equals(crmType) || "STATUS".equals(crmType) ){
                                              //Map to Java Integer
                                              
    stringBuffer.append(TEXT_155);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_156);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_161);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_162);
    
                                  }else if("UNIQUEIDENTIFIER".equals(crmType)){
                                              //Map to Java String
                                              
    stringBuffer.append(TEXT_163);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_164);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_169);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_170);
    
                                  }else{
                                               
    stringBuffer.append(TEXT_171);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_173);
    
                                  }
                        }
                            
    
                                 if("insert".equals(action)){
                                   
    stringBuffer.append(TEXT_174);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_177);
    
                                 }else{
                                   
    stringBuffer.append(TEXT_178);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_181);
    
                                 }
                                 
    
                        }else if("delete".equals(action)){
                            
    stringBuffer.append(TEXT_182);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_184);
    stringBuffer.append( connName );
    stringBuffer.append(TEXT_185);
    
                        }else{
                            
    stringBuffer.append(TEXT_186);
    
                        }
                }
            }
        }
    }

    
        }else{
            
    
	String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
	boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));

    String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
    String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
    if("CustomEntity".equals(entityname)){
		entityname = customEntityname.replaceAll("\"","");
	}
	entityname = entityname.toLowerCase();
    String action = ElementParameterParser.getValue(node,"__ACTION__");

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
	    	List<? extends IConnection> conns = node.getIncomingConnections();
	    	for (IConnection conn : conns) {//3
	    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
	    			String connName = conn.getName();
	    			List<IMetadataColumn> columns = metadata.getListColumns();
	    			int sizeColumns = columns.size();
				 	List<Map<String, String>> lookupMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOKUP_MAPPING__");

	    			if(!isAPI2011 || ("ON_PREMISE").equals(authType)){

		    			if("update".equals(action) && sizeColumns == 2 && "ownerid".equals(columns.get(1).getLabel())){
		    				 action = "reassignOwnerID";
		    			}
		    			boolean hasOwnerID = false;
						
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
						if("insert".equals(action) || "update".equals(action)){//************
						 	List activityEntities = java.util.Arrays.asList(new String[]{"activitypointer","appointment","bulkoperation","campaignactivity","campaignresponse","email","fax","incidentresolution","letter","opportunityclose","orderclose","phonecall","quoteclose","serviceappointment","task"});

		    				if("insert".equals(action))	{
							
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
		    				}else if("update".equals(action))	{
							
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
		    				}
							
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
		    				for(int i = 0; i < sizeColumns; i++){//5

		    					IMetadataColumn column = columns.get(i);

								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

								String entityMethodTemp = column.getLabel();
								String entityMethod = "";

								if("update".equals(action) && "ownerid".equals(column.getLabel()))	{
									hasOwnerID = true;
									continue;
								}

								boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
								if(!isPrimitive) { //begin
								
    stringBuffer.append(TEXT_200);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_202);
    
		    					}
		    					if(!"Id".equals(column.getLabel())){
								
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_206);
    
									if(lookupMapping.size()>0){
										for(Map<String, String> lookupMapper:lookupMapping){
											if(column.getLabel().equals(lookupMapper.get("INPUT_COLUMN"))){
											
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(lookupMapper.get("TYPE"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
											}
										}
									}
									
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
			    					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			        				if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){//Date
									
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_219);
    
									} else {//others
									
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_223);
    
									}
									
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
								}else{
									String entityIdStr = entityname;
									if(activityEntities.contains(entityIdStr)){
										entityIdStr = "activity";
									}
									
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(entityIdStr);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(entityIdStr);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    
								}

								if(!isPrimitive) {//end
								
    stringBuffer.append(TEXT_243);
    
								}
							}//5
		 					if("insert".equals(action)){//#######
							
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
							}else if("update".equals(action)){//#######
							
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    
		  					}//#######
						}else if("delete".equals(action)){//*************
						
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
		  				}//************
		  				if("reassignOwnerID".equals(action) || ("update".equals(action) && hasOwnerID)){
						
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
						}
						
    stringBuffer.append(TEXT_306);
    
					}else{
						Map<String, String> crmTypeMapping = new HashMap<String, String>();
						crmTypeMapping.put("BOOLEAN", "bool");
						crmTypeMapping.put("CUSTOMER", "entityRef");
						crmTypeMapping.put("DATETIME", "datatime");
						crmTypeMapping.put("DECIMAL", "bigDecimal");
						crmTypeMapping.put("DOUBLE", "double");
						crmTypeMapping.put("INTEGER", "int");
						crmTypeMapping.put("LOOKUP", "entityRef");
						crmTypeMapping.put("MEMO", "string");
						crmTypeMapping.put("MONEY", "money");
						crmTypeMapping.put("OWNER", "entityRef");
						crmTypeMapping.put("PARTYLIST", "entityCollection");
						crmTypeMapping.put("PICKLIST", "optionSetValue");
						crmTypeMapping.put("STATE", "optionSetValue");
						crmTypeMapping.put("STATUS", "optionSetValue");
						crmTypeMapping.put("STRING", "string");
						crmTypeMapping.put("UNIQUEIDENTIFIER", "guid");
						crmTypeMapping.put("CALENDARRULES", "entityCollection");
						crmTypeMapping.put("BIGINT", "long");
						crmTypeMapping.put("MANAGEDPROPERTY", "booleanManagedProperty");
						crmTypeMapping.put("ENTITYNAME", "string");

						if("insert".equals(action) || "update".equals(action)){
							String ownerColumnName = null;
							String idColumnName = null;
							
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    
							for(int i = 0; i < sizeColumns; i++){
		    					IMetadataColumn column = columns.get(i);
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String crmType = column.getType();
								String columnName = column.getLabel();
								if("update".equals(action)){
									if("OWNER".equals(crmType)){
										ownerColumnName = columnName;
										continue;
									}
									if(column.isKey() && idColumnName == null){
										idColumnName = columnName;
									}
								}
								boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
								if(!isPrimitive) {
								//if you want to set null, just skip this step.
								
    stringBuffer.append(TEXT_314);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_316);
    
		    					}
		    					
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_321);
    
		    					if("entityRef".equals(crmTypeMapping.get(crmType))){
									boolean hasFound = false;
									if(lookupMapping.size()>0){
										for(Map<String, String> lookupMapper:lookupMapping){
											if(columnName.equals(lookupMapper.get("INPUT_COLUMN"))){
												hasFound = true;
												
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(lookupMapper.get("TYPE"));
    stringBuffer.append(TEXT_328);
    
											}
										}
									}
									if(!hasFound){
									
    stringBuffer.append(TEXT_329);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_330);
    
									}
								}else if("optionSetValue".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_335);
    
								}else if("money".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_340);
    
								}else if("guid".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_345);
    
								}else if("string".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_350);
    
								}else if("datatime".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_355);
    
								}else if("bool".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_360);
    
								}else if("bigDecimal".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_365);
    
								}else if("int".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_370);
    
								}else if("long".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_375);
    
								}else if("double".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_380);
    
								}else if("entityCollection".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_381);
    
								}else if("booleanManagedProperty".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_382);
    
								}else{
								
    stringBuffer.append(TEXT_383);
    stringBuffer.append(crmType);
    stringBuffer.append(TEXT_384);
    
								}
								
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    
								if(!isPrimitive) {
								
    stringBuffer.append(TEXT_388);
    
								}
							}
							
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    if("insert".equals(action)){
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    
							}else if("update".equals(action)){
								if(ownerColumnName != null && columns.size() == 2){
								//don't need to update, just do reassign opertion is enough.
								}else{
								
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
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
    
								}
								if(ownerColumnName != null){
								
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(idColumnName);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(ownerColumnName);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    
								}
							}
						}
						else if("delete".equals(action)){
						
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
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
    
						}
					}
					
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    
	    		}//4
	    	}//3
	    }//2
	}//1
	
    
        }

    stringBuffer.append(TEXT_472);
    return stringBuffer.toString();
  }
}
