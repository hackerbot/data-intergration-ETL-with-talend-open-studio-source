package org.talend.designer.codegen.translators.databases.vertica;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TVerticaOutputMainJava {
  protected static String nl;
  public static synchronized TVerticaOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVerticaOutputMainJava result = new TVerticaOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
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
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL + "            ";
  protected final String TEXT_44 = " = null;";
  protected final String TEXT_45 = NL + "        query_";
  protected final String TEXT_46 = " = new StringBuffer(\"\");";
  protected final String TEXT_47 = NL + "                java.sql.Statement stmtCreateProjection_";
  protected final String TEXT_48 = " = conn_";
  protected final String TEXT_49 = ".createStatement();" + NL + "                stmtCreateProjection_";
  protected final String TEXT_50 = ".execute(\"CREATE PROJECTION \" + tableName_";
  protected final String TEXT_51 = " + \"_proj (";
  protected final String TEXT_52 = ") AS SELECT ";
  protected final String TEXT_53 = " FROM \" + tableName_";
  protected final String TEXT_54 = ");" + NL + "                stmtCreateProjection_";
  protected final String TEXT_55 = ".close();";
  protected final String TEXT_56 = NL + "                if(!whetherExist_";
  protected final String TEXT_57 = ") {";
  protected final String TEXT_58 = NL + "                }";
  protected final String TEXT_59 = NL + "                stmtBuilder_";
  protected final String TEXT_60 = " = new StringBuilder();" + NL + "                stmt_";
  protected final String TEXT_61 = " = conn_";
  protected final String TEXT_62 = ".createStatement();" + NL + "                template_";
  protected final String TEXT_63 = " = \"COPY \" + tableName_";
  protected final String TEXT_64 = " +\" (";
  protected final String TEXT_65 = ")\" + \" FROM STDIN UNCOMPRESSED WITH DELIMITER ';' RECORD TERMINATOR '\\n' ENCLOSED BY '|' NULL AS '' ";
  protected final String TEXT_66 = "DIRECT";
  protected final String TEXT_67 = "\";";
  protected final String TEXT_68 = NL + "                        for(int i_";
  protected final String TEXT_69 = " = 0; i_";
  protected final String TEXT_70 = " < ";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ".getColumnCount(); i_";
  protected final String TEXT_73 = "++) {" + NL + "                            Object currentValue_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = ".getColumnValue(i_";
  protected final String TEXT_77 = ");" + NL + "                            if(currentValue_";
  protected final String TEXT_78 = " == null) {" + NL + "                                stmtBuilder_";
  protected final String TEXT_79 = ".append(\"\");" + NL + "                            } else {" + NL + "                                stmtBuilder_";
  protected final String TEXT_80 = ".append(\"|\");" + NL + "                                routines.system.DynamicMetadata metadata_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = ".getColumnMetadata(i_";
  protected final String TEXT_84 = ");" + NL + "                                if(\"id_String\".equals(metadata_";
  protected final String TEXT_85 = ".getType())) {" + NL + "                                    stmtBuilder_";
  protected final String TEXT_86 = ".append(String.valueOf(currentValue_";
  protected final String TEXT_87 = ").replaceAll(\"\\\\|\",\"\\\\\\\\|\"));" + NL + "                                } else if(\"id_Date\".equals(metadata_";
  protected final String TEXT_88 = ".getType())) {" + NL + "                                    stmtBuilder_";
  protected final String TEXT_89 = ".append(FormatterUtils.format_Date((java.util.Date)currentValue_";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = "));" + NL + "                                } else if(\"id_Byte\".equals(metadata_";
  protected final String TEXT_92 = ".getType())" + NL + "                                    || \"id_Short\".equals(metadata_";
  protected final String TEXT_93 = ".getType())" + NL + "                                    || \"id_Integer\".equals(metadata_";
  protected final String TEXT_94 = ".getType())" + NL + "                                    || \"id_Long\".equals(metadata_";
  protected final String TEXT_95 = ".getType())" + NL + "                                ) {" + NL + "                                    stmtBuilder_";
  protected final String TEXT_96 = ".append(FormatterUtils.format_Number(String.valueOf(currentValue_";
  protected final String TEXT_97 = "), null, '.'));" + NL + "                                } else if(\"id_BigDecimal\".equals(metadata_";
  protected final String TEXT_98 = ".getType())) {" + NL + "                                    BigDecimal decimal_";
  protected final String TEXT_99 = " = (BigDecimal)currentValue_";
  protected final String TEXT_100 = ";" + NL + "                                    stmtBuilder_";
  protected final String TEXT_101 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_102 = "), null, '.'));" + NL + "                                } else if(\"id_Float\".equals(metadata_";
  protected final String TEXT_103 = ".getType())) {" + NL + "                                    BigDecimal decimal_";
  protected final String TEXT_104 = " = new BigDecimal((Float)currentValue_";
  protected final String TEXT_105 = ");" + NL + "                                    stmtBuilder_";
  protected final String TEXT_106 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_107 = "), null, '.'));" + NL + "                                } else if(\"id_Double\".equals(metadata_";
  protected final String TEXT_108 = ".getType())) {" + NL + "                                    BigDecimal decimal_";
  protected final String TEXT_109 = " = new BigDecimal((Double)currentValue_";
  protected final String TEXT_110 = ");" + NL + "                                    stmtBuilder_";
  protected final String TEXT_111 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_112 = "), null, '.'));" + NL + "                                } else if(\"id_byte[]\".equals(metadata_";
  protected final String TEXT_113 = ".getType())) {" + NL + "                                    stmtBuilder_";
  protected final String TEXT_114 = ".append(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap((byte[])currentValue_";
  protected final String TEXT_115 = ")).toString());" + NL + "                                } else {" + NL + "                                    stmtBuilder_";
  protected final String TEXT_116 = ".append(String.valueOf(currentValue_";
  protected final String TEXT_117 = "));" + NL + "                                }" + NL + "                                stmtBuilder_";
  protected final String TEXT_118 = ".append(\"|\");" + NL + "                            }" + NL + "" + NL + "                            if(i_";
  protected final String TEXT_119 = " < (";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = ".getColumnCount() - 1)) {" + NL + "                                stmtBuilder_";
  protected final String TEXT_122 = ".append(\";\");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_123 = NL + "                        stmtBuilder_";
  protected final String TEXT_124 = ".append(\"|\");" + NL + "                        stmtBuilder_";
  protected final String TEXT_125 = ".append(String.valueOf(";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = "));" + NL + "                        stmtBuilder_";
  protected final String TEXT_128 = ".append(\"|\");";
  protected final String TEXT_129 = NL + "                        if(";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " == null){" + NL + "                            stmtBuilder_";
  protected final String TEXT_132 = ".append(\"\");" + NL + "                        }else{" + NL + "                            stmtBuilder_";
  protected final String TEXT_133 = ".append(\"|\");";
  protected final String TEXT_134 = NL + "                                stmtBuilder_";
  protected final String TEXT_135 = ".append(";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = ".replaceAll(\"\\\\|\",\"\\\\\\\\|\"));";
  protected final String TEXT_138 = NL + "                                stmtBuilder_";
  protected final String TEXT_139 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = ", ";
  protected final String TEXT_142 = "));";
  protected final String TEXT_143 = NL + "                                stmtBuilder_";
  protected final String TEXT_144 = ".append(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = ")).toString());";
  protected final String TEXT_147 = NL + "                                    stmtBuilder_";
  protected final String TEXT_148 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_149 = "), null, '.'));";
  protected final String TEXT_150 = NL + "                                    if (";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " != null) {" + NL + "                                        BigDecimal decimal_";
  protected final String TEXT_153 = " = new BigDecimal(";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ");" + NL + "                                        stmtBuilder_";
  protected final String TEXT_156 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_157 = "), null, '.'));" + NL + "                                    }";
  protected final String TEXT_158 = NL + "                                    stmtBuilder_";
  protected final String TEXT_159 = ".append(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = "), null, '.'));";
  protected final String TEXT_162 = NL + "                                stmtBuilder_";
  protected final String TEXT_163 = ".append(String.valueOf(";
  protected final String TEXT_164 = "));";
  protected final String TEXT_165 = NL + "                                stmtBuilder_";
  protected final String TEXT_166 = ".append(String.valueOf(";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = "));";
  protected final String TEXT_169 = NL + "                            stmtBuilder_";
  protected final String TEXT_170 = ".append(\"|\");" + NL + "                        }";
  protected final String TEXT_171 = NL + "                    stmtBuilder_";
  protected final String TEXT_172 = ".append(\"";
  protected final String TEXT_173 = "\");";
  protected final String TEXT_174 = NL + "                    nb_line_";
  protected final String TEXT_175 = "++;";
  protected final String TEXT_176 = NL + "                        batchSizeCounter_";
  protected final String TEXT_177 = "++;";
  protected final String TEXT_178 = NL + "        if(nb_line_";
  protected final String TEXT_179 = "==0) {";
  protected final String TEXT_180 = "            " + NL + "            java.sql.Statement stmtDrop_";
  protected final String TEXT_181 = " = conn_";
  protected final String TEXT_182 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_183 = NL + "            stmtDrop_";
  protected final String TEXT_184 = ".execute(\"";
  protected final String TEXT_185 = "\" ";
  protected final String TEXT_186 = ");" + NL + "\t\t\t";
  protected final String TEXT_187 = NL + "            stmtDrop_";
  protected final String TEXT_188 = ".close();" + NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_189 = " = conn_";
  protected final String TEXT_190 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_193 = ".execute(((\"";
  protected final String TEXT_194 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = ", \"";
  protected final String TEXT_197 = "\")";
  protected final String TEXT_198 = ".toUpperCase()";
  protected final String TEXT_199 = ")+\")";
  protected final String TEXT_200 = "\"));" + NL + "\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_202 = ".execute(\"";
  protected final String TEXT_203 = ")\");" + NL + "\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\tstmtCreate_";
  protected final String TEXT_206 = ".close();" + NL + "\t\t";
  protected final String TEXT_207 = NL + "            java.sql.Statement stmtCreate_";
  protected final String TEXT_208 = " = conn_";
  protected final String TEXT_209 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\t";
  protected final String TEXT_211 = NL + "\t\t\t\t\tstmtCreate_";
  protected final String TEXT_212 = ".execute(((\"";
  protected final String TEXT_213 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_214 = ".";
  protected final String TEXT_215 = ", \"";
  protected final String TEXT_216 = "\")";
  protected final String TEXT_217 = ".toUpperCase()";
  protected final String TEXT_218 = ")+\")";
  protected final String TEXT_219 = "\"));" + NL + "\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\tstmtCreate_";
  protected final String TEXT_221 = ".execute(\"";
  protected final String TEXT_222 = ")\");" + NL + "\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t";
  protected final String TEXT_224 = NL + "            stmtCreate_";
  protected final String TEXT_225 = ".close();" + NL + "\t\t";
  protected final String TEXT_226 = NL + "\t\t\t";
  protected final String TEXT_227 = "\t         " + NL + "\t\t    " + NL + "    \t\t    ";
  protected final String TEXT_228 = NL + "\t\t    \t\tString keyCheckTable_";
  protected final String TEXT_229 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_230 = "+\"][\"+";
  protected final String TEXT_231 = "+\"][\"+";
  protected final String TEXT_232 = "+\"][\"+";
  protected final String TEXT_233 = "+\"][\"+";
  protected final String TEXT_234 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_235 = " + \"]\";" + NL + "\t\t    \t";
  protected final String TEXT_236 = NL + "        \t\t    // [%connection%][checktable][tableName]" + NL + "        \t\t    String keyCheckTable_";
  protected final String TEXT_237 = " = conn_";
  protected final String TEXT_238 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_239 = " + \"]\";" + NL + "    \t\t    ";
  protected final String TEXT_240 = NL + "\t\t    " + NL + "\t\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_241 = ")== null){//}" + NL + "\t\t\t" + NL + "\t\t\t\t\tsynchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_242 = ")) {//}" + NL + "\t\t\t\t\t\tif(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_243 = ")== null){//}" + NL + "\t\t\t";
  protected final String TEXT_244 = "              " + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_245 = NL + "    \t\t\t\t\t\t\tjava.sql.Statement isExistStmt_";
  protected final String TEXT_246 = " = conn_";
  protected final String TEXT_247 = ".createStatement();" + NL + "                \t\t\t\tboolean whetherExist_";
  protected final String TEXT_248 = " = false;" + NL + "                \t\t\t\ttry {" + NL + "                \t\t\t\t\tisExistStmt_";
  protected final String TEXT_249 = ".execute(\"SELECT TOP 1 1 FROM [\" +  tableName_";
  protected final String TEXT_250 = " + \"]\" );" + NL + "                \t\t\t\t\twhetherExist_";
  protected final String TEXT_251 = " = true;" + NL + "                \t\t\t\t} catch (java.lang.Exception e){" + NL + "                \t\t\t\t\twhetherExist_";
  protected final String TEXT_252 = " = false;" + NL + "                \t\t\t\t}" + NL + "                \t\t\t\tisExistStmt_";
  protected final String TEXT_253 = ".close();" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_254 = "   \t" + NL + "                \t\t\t\t";
  protected final String TEXT_255 = NL + "                \t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_256 = " = conn_";
  protected final String TEXT_257 = ".getMetaData();" + NL + "                \t            if(tableNameForSearch_";
  protected final String TEXT_258 = ".indexOf(\"\\\"\")==-1){" + NL + "                            \t\ttableNameForSearch_";
  protected final String TEXT_259 = " = tableNameForSearch_";
  protected final String TEXT_260 = ".toUpperCase();" + NL + "                            \t}else{" + NL + "                            \t\ttableNameForSearch_";
  protected final String TEXT_261 = " = tableNameForSearch_";
  protected final String TEXT_262 = ".replaceAll(\"\\\"\",\"\");" + NL + "                            \t}" + NL + "                \t            java.sql.ResultSet rsTable_";
  protected final String TEXT_263 = " = dbMetaData_";
  protected final String TEXT_264 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_265 = ", tableNameForSearch_";
  protected final String TEXT_266 = ", new String[]{\"TABLE\"});" + NL + "                \t            boolean whetherExist_";
  protected final String TEXT_267 = " = false;" + NL + "                \t            if(rsTable_";
  protected final String TEXT_268 = ".next()) {" + NL + "                \t            \twhetherExist_";
  protected final String TEXT_269 = " = true;" + NL + "                \t            }" + NL + "    \t            \t\t\trsTable_";
  protected final String TEXT_270 = ".close();" + NL + "    \t            " + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_271 = "  \t            " + NL + "                \t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_272 = " = conn_";
  protected final String TEXT_273 = ".getMetaData();" + NL + "                \t            java.sql.ResultSet rsTable_";
  protected final String TEXT_274 = " = dbMetaData_";
  protected final String TEXT_275 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                \t            boolean whetherExist_";
  protected final String TEXT_276 = " = false;" + NL + "                \t            while(rsTable_";
  protected final String TEXT_277 = ".next()) {" + NL + "                \t                String table_";
  protected final String TEXT_278 = " = rsTable_";
  protected final String TEXT_279 = ".getString(\"TABLE_NAME\");" + NL + "                \t                String schema_";
  protected final String TEXT_280 = " = rsTable_";
  protected final String TEXT_281 = ".getString(\"TABLE_SCHEM\");" + NL + "                \t                if(table_";
  protected final String TEXT_282 = ".equals";
  protected final String TEXT_283 = "IgnoreCase";
  protected final String TEXT_284 = "(";
  protected final String TEXT_285 = ") " + NL + "                \t                \t&& (schema_";
  protected final String TEXT_286 = ".equals";
  protected final String TEXT_287 = "IgnoreCase";
  protected final String TEXT_288 = "(dbschema_";
  protected final String TEXT_289 = ") || dbschema_";
  protected final String TEXT_290 = ".trim().length() ==0)) {" + NL + "                \t                    whetherExist_";
  protected final String TEXT_291 = " = true;" + NL + "                \t                    break;" + NL + "        \t            \t    \t}" + NL + "                        \t\t}" + NL + "            \t            \trsTable_";
  protected final String TEXT_292 = ".close();" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_293 = NL + "                \t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_294 = " = conn_";
  protected final String TEXT_295 = ".getMetaData();" + NL + "                \t            java.sql.ResultSet rsTable_";
  protected final String TEXT_296 = " = dbMetaData_";
  protected final String TEXT_297 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                \t            boolean whetherExist_";
  protected final String TEXT_298 = " = false;" + NL + "                \t            while(rsTable_";
  protected final String TEXT_299 = ".next()) {" + NL + "                \t                String table_";
  protected final String TEXT_300 = " = rsTable_";
  protected final String TEXT_301 = ".getString(\"TABLE_NAME\");" + NL + "                \t                String schema_";
  protected final String TEXT_302 = " = rsTable_";
  protected final String TEXT_303 = ".getString(\"TABLE_SCHEM\");" + NL + "                \t                if(table_";
  protected final String TEXT_304 = ".equals";
  protected final String TEXT_305 = "IgnoreCase";
  protected final String TEXT_306 = "((";
  protected final String TEXT_307 = ")";
  protected final String TEXT_308 = ".toUpperCase()";
  protected final String TEXT_309 = ") " + NL + "                \t                \t&& (schema_";
  protected final String TEXT_310 = ".equals";
  protected final String TEXT_311 = "IgnoreCase";
  protected final String TEXT_312 = "(dbschema_";
  protected final String TEXT_313 = ") || (dbschema_";
  protected final String TEXT_314 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_315 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_316 = ")))) {" + NL + "                \t                    whetherExist_";
  protected final String TEXT_317 = " = true;" + NL + "                \t                    break;" + NL + "                \t                }" + NL + "                \t            }" + NL + "                \t            rsTable_";
  protected final String TEXT_318 = ".close();" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_319 = "  \t            " + NL + "                \t\t\t\tjava.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_320 = " = conn_";
  protected final String TEXT_321 = ".getMetaData();" + NL + "                \t            java.sql.ResultSet rsTable_";
  protected final String TEXT_322 = " = dbMetaData_";
  protected final String TEXT_323 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                \t            boolean whetherExist_";
  protected final String TEXT_324 = " = false;" + NL + "                \t            String defaultSchema_";
  protected final String TEXT_325 = " = \"public\";" + NL + "                \t            if(dbschema_";
  protected final String TEXT_326 = " == null || dbschema_";
  protected final String TEXT_327 = ".trim().length() == 0) {" + NL + "                \t            \tjava.sql.Statement stmtSchema_";
  protected final String TEXT_328 = " = conn_";
  protected final String TEXT_329 = ".createStatement();" + NL + "                \t            \tjava.sql.ResultSet rsSchema_";
  protected final String TEXT_330 = " = stmtSchema_";
  protected final String TEXT_331 = ".executeQuery(\"select current_schema() \");" + NL + "                \t            \twhile(rsSchema_";
  protected final String TEXT_332 = ".next()){" + NL + "                \t            \t\tdefaultSchema_";
  protected final String TEXT_333 = " = rsSchema_";
  protected final String TEXT_334 = ".getString(\"current_schema\");" + NL + "                \t            \t}" + NL + "                \t            \trsSchema_";
  protected final String TEXT_335 = ".close();" + NL + "                \t            \tstmtSchema_";
  protected final String TEXT_336 = ".close();" + NL + "                \t            }" + NL + "                \t            while(rsTable_";
  protected final String TEXT_337 = ".next()) {" + NL + "                \t                String table_";
  protected final String TEXT_338 = " = rsTable_";
  protected final String TEXT_339 = ".getString(\"TABLE_NAME\");" + NL + "                \t                String schema_";
  protected final String TEXT_340 = " = rsTable_";
  protected final String TEXT_341 = ".getString(\"TABLE_SCHEM\");" + NL + "                \t                if(table_";
  protected final String TEXT_342 = ".equals";
  protected final String TEXT_343 = "IgnoreCase";
  protected final String TEXT_344 = "(";
  protected final String TEXT_345 = ") " + NL + "                \t                \t&& (schema_";
  protected final String TEXT_346 = ".equals";
  protected final String TEXT_347 = "IgnoreCase";
  protected final String TEXT_348 = "(dbschema_";
  protected final String TEXT_349 = ") || ((dbschema_";
  protected final String TEXT_350 = " ==null || dbschema_";
  protected final String TEXT_351 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_352 = ".equals";
  protected final String TEXT_353 = "IgnoreCase";
  protected final String TEXT_354 = "(schema_";
  protected final String TEXT_355 = ")))) {" + NL + "                \t                    whetherExist_";
  protected final String TEXT_356 = " = true;" + NL + "                \t                    break;" + NL + "                \t                }" + NL + "                \t            }" + NL + "                \t            rsTable_";
  protected final String TEXT_357 = ".close();" + NL + "        \t\t\t\t\t";
  protected final String TEXT_358 = "      " + NL + "                \t            java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_359 = " = conn_";
  protected final String TEXT_360 = ".getMetaData();" + NL + "                \t            java.sql.ResultSet rsTable_";
  protected final String TEXT_361 = " = dbMetaData_";
  protected final String TEXT_362 = ".getTables(null, null, null, new String[]{\"TABLE\"});" + NL + "                \t            boolean whetherExist_";
  protected final String TEXT_363 = " = false;" + NL + "                \t            while(rsTable_";
  protected final String TEXT_364 = ".next()) {" + NL + "                \t                String table_";
  protected final String TEXT_365 = " = rsTable_";
  protected final String TEXT_366 = ".getString(\"TABLE_NAME\");" + NL + "                \t                if(table_";
  protected final String TEXT_367 = ".equalsIgnoreCase(";
  protected final String TEXT_368 = ")) {" + NL + "                \t                    whetherExist_";
  protected final String TEXT_369 = " = true;" + NL + "                \t                    break;" + NL + "                \t                }" + NL + "                \t            }" + NL + "                \t            rsTable_";
  protected final String TEXT_370 = ".close();" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_371 = NL + "                    \t\t\tif(!whetherExist_";
  protected final String TEXT_372 = ") {" + NL + "                                    java.sql.Statement stmtCreate_";
  protected final String TEXT_373 = " = conn_";
  protected final String TEXT_374 = ".createStatement();" + NL + "                        \t\t\t";
  protected final String TEXT_375 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_376 = NL + "    \t\t\t\t\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_377 = ".execute(((\"";
  protected final String TEXT_378 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_379 = ".";
  protected final String TEXT_380 = ", \"";
  protected final String TEXT_381 = "\")";
  protected final String TEXT_382 = ".toUpperCase()";
  protected final String TEXT_383 = ")+\")";
  protected final String TEXT_384 = "\"));" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_385 = NL + "    \t\t\t\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_386 = ".execute(\"";
  protected final String TEXT_387 = ")\");" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_388 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_389 = NL + "                    \t\t\t\tstmtCreate_";
  protected final String TEXT_390 = ".close();            " + NL + "                    \t\t\t}                " + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_391 = NL + "                                if(whetherExist_";
  protected final String TEXT_392 = ") {" + NL + "                                    java.sql.Statement stmtDrop_";
  protected final String TEXT_393 = " = conn_";
  protected final String TEXT_394 = ".createStatement();" + NL + "                \t    \t    \t";
  protected final String TEXT_395 = NL + "                                    stmtDrop_";
  protected final String TEXT_396 = ".execute(\"";
  protected final String TEXT_397 = "\" ";
  protected final String TEXT_398 = ");" + NL + "                \t    \t    \t";
  protected final String TEXT_399 = NL + "                                    stmtDrop_";
  protected final String TEXT_400 = ".close();" + NL + "                                }" + NL + "                                java.sql.Statement stmtCreate_";
  protected final String TEXT_401 = " = conn_";
  protected final String TEXT_402 = ".createStatement();" + NL + "            \t    \t    \t";
  protected final String TEXT_403 = NL + "        \t\t\t\t\t\t";
  protected final String TEXT_404 = NL + "        \t\t\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_405 = ".execute(((\"";
  protected final String TEXT_406 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_407 = ".";
  protected final String TEXT_408 = ", \"";
  protected final String TEXT_409 = "\")";
  protected final String TEXT_410 = ".toUpperCase()";
  protected final String TEXT_411 = ")+\")";
  protected final String TEXT_412 = "\"));" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_413 = NL + "        \t\t\t\t\t\t\tstmtCreate_";
  protected final String TEXT_414 = ".execute(\"";
  protected final String TEXT_415 = ")\");" + NL + "        \t\t\t\t\t\t";
  protected final String TEXT_416 = NL + "        \t    \t    \t\t";
  protected final String TEXT_417 = NL + "                        \t\tstmtCreate_";
  protected final String TEXT_418 = ".close();" + NL + "        \t\t\t\t\t";
  protected final String TEXT_419 = NL + "\t\t\t";
  protected final String TEXT_420 = NL + "    \t\t\t\t\t\tGlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_421 = ", true);" + NL + "    \t\t//{{{" + NL + "    \t\t\t\t\t} // end of if" + NL + "    \t\t\t\t} // end synchronized" + NL + "    \t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_422 = "            ";
  protected final String TEXT_423 = NL + "            java.sql.Statement stmtClear_";
  protected final String TEXT_424 = " = conn_";
  protected final String TEXT_425 = ".createStatement();" + NL + "    \t   \t";
  protected final String TEXT_426 = NL + "            stmtClear_";
  protected final String TEXT_427 = ".executeUpdate(\"";
  protected final String TEXT_428 = "\");" + NL + "   \t    \t";
  protected final String TEXT_429 = NL + "            stmtClear_";
  protected final String TEXT_430 = ".close();" + NL + "\t\t";
  protected final String TEXT_431 = NL + "            java.sql.Statement stmtTruncCount_";
  protected final String TEXT_432 = " = conn_";
  protected final String TEXT_433 = ".createStatement();" + NL + "            java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_434 = " = stmtTruncCount_";
  protected final String TEXT_435 = ".executeQuery(\"";
  protected final String TEXT_436 = "\");" + NL + "            int rsTruncCountNumber_";
  protected final String TEXT_437 = " = 0;" + NL + "            if(rsTruncCount_";
  protected final String TEXT_438 = ".next()) {" + NL + "\t\t\t\trsTruncCountNumber_";
  protected final String TEXT_439 = " = rsTruncCount_";
  protected final String TEXT_440 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_441 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_442 = ".close();" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_443 = " = conn_";
  protected final String TEXT_444 = ".createStatement();" + NL + "\t\t\t";
  protected final String TEXT_445 = NL + "\t\t\t";
  protected final String TEXT_446 = NL + "\t\t\t\tconn_";
  protected final String TEXT_447 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_448 = NL + "            stmtTrunc_";
  protected final String TEXT_449 = ".executeUpdate(\"";
  protected final String TEXT_450 = "\");";
  protected final String TEXT_451 = NL + "                if(!conn_";
  protected final String TEXT_452 = ".getAutoCommit()){" + NL + "                    conn_";
  protected final String TEXT_453 = ".commit();" + NL + "                }";
  protected final String TEXT_454 = NL + "   \t    \t";
  protected final String TEXT_455 = NL + "   \t    \tdeletedCount_";
  protected final String TEXT_456 = " += rsTruncCountNumber_";
  protected final String TEXT_457 = ";" + NL + "            stmtTrunc_";
  protected final String TEXT_458 = ".close();            " + NL + "\t\t";
  protected final String TEXT_459 = NL + "\t\t \tjava.sql.Statement stmtTruncCount_";
  protected final String TEXT_460 = " = conn_";
  protected final String TEXT_461 = ".createStatement();" + NL + "\t\t \tjava.sql.ResultSet rsTruncCount_";
  protected final String TEXT_462 = " = stmtTruncCount_";
  protected final String TEXT_463 = ".executeQuery(\"";
  protected final String TEXT_464 = "\");" + NL + "            java.sql.Statement stmtTrunc_";
  protected final String TEXT_465 = " = conn_";
  protected final String TEXT_466 = ".createStatement();" + NL + "  \t    \t";
  protected final String TEXT_467 = NL + "\t\t\t";
  protected final String TEXT_468 = NL + "\t\t\t\tconn_";
  protected final String TEXT_469 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_470 = NL + "            stmtTrunc_";
  protected final String TEXT_471 = ".executeUpdate(\"";
  protected final String TEXT_472 = "\");" + NL + "   \t    \t";
  protected final String TEXT_473 = NL + "            while(rsTruncCount_";
  protected final String TEXT_474 = ".next()) {" + NL + "                deletedCount_";
  protected final String TEXT_475 = " += rsTruncCount_";
  protected final String TEXT_476 = ".getInt(1);" + NL + "            }" + NL + "            rsTruncCount_";
  protected final String TEXT_477 = ".close();" + NL + "            stmtTruncCount_";
  protected final String TEXT_478 = ".close();" + NL + "            stmtTrunc_";
  protected final String TEXT_479 = ".close();" + NL + "\t\t";
  protected final String TEXT_480 = NL + "                String insert_";
  protected final String TEXT_481 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_482 = " + \" (";
  protected final String TEXT_483 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_484 = ".";
  protected final String TEXT_485 = ", \"";
  protected final String TEXT_486 = "\")+\") VALUES (";
  protected final String TEXT_487 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_488 = ".";
  protected final String TEXT_489 = ")+\")\";";
  protected final String TEXT_490 = NL + "                String insert_";
  protected final String TEXT_491 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_492 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = ", \"";
  protected final String TEXT_495 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_496 = ".";
  protected final String TEXT_497 = ")+\")\";";
  protected final String TEXT_498 = NL + "        pstmt_";
  protected final String TEXT_499 = " = conn_";
  protected final String TEXT_500 = ".prepareStatement(insert_";
  protected final String TEXT_501 = ");";
  protected final String TEXT_502 = NL + "                String update_";
  protected final String TEXT_503 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_504 = " + \" SET ";
  protected final String TEXT_505 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_506 = ".";
  protected final String TEXT_507 = ", \"";
  protected final String TEXT_508 = "\")+\" WHERE ";
  protected final String TEXT_509 = "\";";
  protected final String TEXT_510 = NL + "                String update_";
  protected final String TEXT_511 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_512 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_513 = ".";
  protected final String TEXT_514 = ", \"";
  protected final String TEXT_515 = "\")+\" WHERE ";
  protected final String TEXT_516 = "\";";
  protected final String TEXT_517 = NL + "        pstmt_";
  protected final String TEXT_518 = " = conn_";
  protected final String TEXT_519 = ".prepareStatement(update_";
  protected final String TEXT_520 = ");";
  protected final String TEXT_521 = NL + "                String insert_";
  protected final String TEXT_522 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_523 = " + \" (";
  protected final String TEXT_524 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_525 = ".";
  protected final String TEXT_526 = ", \"";
  protected final String TEXT_527 = "\")+\") VALUES (";
  protected final String TEXT_528 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_529 = ".";
  protected final String TEXT_530 = ")+\")\";";
  protected final String TEXT_531 = NL + "                String insert_";
  protected final String TEXT_532 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_533 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_534 = ".";
  protected final String TEXT_535 = ", \"";
  protected final String TEXT_536 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_537 = ".";
  protected final String TEXT_538 = ")+\")\";";
  protected final String TEXT_539 = NL + "                String update_";
  protected final String TEXT_540 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_541 = " + \" SET ";
  protected final String TEXT_542 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_543 = ".";
  protected final String TEXT_544 = ", \"";
  protected final String TEXT_545 = "\")+\" WHERE ";
  protected final String TEXT_546 = "\";";
  protected final String TEXT_547 = NL + "                String update_";
  protected final String TEXT_548 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_549 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_550 = ".";
  protected final String TEXT_551 = ", \"";
  protected final String TEXT_552 = "\")+\" WHERE ";
  protected final String TEXT_553 = "\";";
  protected final String TEXT_554 = NL + "        pstmt_";
  protected final String TEXT_555 = " = conn_";
  protected final String TEXT_556 = ".prepareStatement(\"SELECT COUNT(1) FROM \" + tableName_";
  protected final String TEXT_557 = " + \" WHERE ";
  protected final String TEXT_558 = "\");" + NL + "        pstmtInsert_";
  protected final String TEXT_559 = " = conn_";
  protected final String TEXT_560 = ".prepareStatement(insert_";
  protected final String TEXT_561 = ");" + NL + "        pstmtUpdate_";
  protected final String TEXT_562 = " = conn_";
  protected final String TEXT_563 = ".prepareStatement(update_";
  protected final String TEXT_564 = ");";
  protected final String TEXT_565 = NL + "                String insert_";
  protected final String TEXT_566 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_567 = " + \" (";
  protected final String TEXT_568 = ", \"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_569 = ".";
  protected final String TEXT_570 = ", \"";
  protected final String TEXT_571 = "\")+\") VALUES (";
  protected final String TEXT_572 = ", \"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_573 = ".";
  protected final String TEXT_574 = ")+\")\";";
  protected final String TEXT_575 = NL + "                String insert_";
  protected final String TEXT_576 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_577 = " + \" (\"+DynamicUtils.getInsertIntoStmtColumnsList(";
  protected final String TEXT_578 = ".";
  protected final String TEXT_579 = ", \"";
  protected final String TEXT_580 = "\")+\") VALUES (\"+DynamicUtils.getInsertIntoStmtValuesList(";
  protected final String TEXT_581 = ".";
  protected final String TEXT_582 = ")+\")\";";
  protected final String TEXT_583 = NL + "                String update_";
  protected final String TEXT_584 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_585 = " + \" SET ";
  protected final String TEXT_586 = ", \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_587 = ".";
  protected final String TEXT_588 = ", \"";
  protected final String TEXT_589 = "\")+\" WHERE ";
  protected final String TEXT_590 = "\";";
  protected final String TEXT_591 = NL + "                String update_";
  protected final String TEXT_592 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_593 = " + \" SET \"+DynamicUtils.getUpdateSet(";
  protected final String TEXT_594 = ".";
  protected final String TEXT_595 = ", \"";
  protected final String TEXT_596 = "\")+\" WHERE ";
  protected final String TEXT_597 = "\";";
  protected final String TEXT_598 = NL + "        pstmtUpdate_";
  protected final String TEXT_599 = " = conn_";
  protected final String TEXT_600 = ".prepareStatement(update_";
  protected final String TEXT_601 = ");" + NL + "        pstmtInsert_";
  protected final String TEXT_602 = " = conn_";
  protected final String TEXT_603 = ".prepareStatement(insert_";
  protected final String TEXT_604 = ");";
  protected final String TEXT_605 = NL + "        String delete_";
  protected final String TEXT_606 = " = \"DELETE  FROM \" + tableName_";
  protected final String TEXT_607 = " + \" WHERE ";
  protected final String TEXT_608 = "\";" + NL + "        pstmt_";
  protected final String TEXT_609 = " = conn_";
  protected final String TEXT_610 = ".prepareStatement(delete_";
  protected final String TEXT_611 = ");";
  protected final String TEXT_612 = NL + "\t\t \tinsertSQLSplits_";
  protected final String TEXT_613 = " = insert_";
  protected final String TEXT_614 = ".split(\"\\\\?\");";
  protected final String TEXT_615 = NL + "\t\t\tupdate_";
  protected final String TEXT_616 = " += \" \";" + NL + "\t    \tupdateSQLSplits_";
  protected final String TEXT_617 = " = update_";
  protected final String TEXT_618 = ".split(\"\\\\?\");";
  protected final String TEXT_619 = NL + "\t\t\tupdate_";
  protected final String TEXT_620 = " += \" \";" + NL + "\t\t\tupdateSQLSplits_";
  protected final String TEXT_621 = " = update_";
  protected final String TEXT_622 = ".split(\"\\\\?\");" + NL + "\t\t\tinsertSQLSplits_";
  protected final String TEXT_623 = " = insert_";
  protected final String TEXT_624 = ".split(\"\\\\?\");";
  protected final String TEXT_625 = NL + "\t\t\tdelete_";
  protected final String TEXT_626 = " += \" \";" + NL + "\t\t   \tdeleteSQLSplits_";
  protected final String TEXT_627 = " = delete_";
  protected final String TEXT_628 = ".split(\"\\\\?\");";
  protected final String TEXT_629 = NL + "\t\t\treplace_";
  protected final String TEXT_630 = " += \" \";" + NL + "\t\t\treplaceSQLSplits_";
  protected final String TEXT_631 = " = replace_";
  protected final String TEXT_632 = ".split(\"\\\\?\");";
  protected final String TEXT_633 = NL + "\t\t\tinsertIgnore_";
  protected final String TEXT_634 = " += \" \";" + NL + "\t\t\tinsertIgnoreSQLSplits_";
  protected final String TEXT_635 = " = insertIgnore_";
  protected final String TEXT_636 = ".split(\"\\\\?\");";
  protected final String TEXT_637 = NL + "\t\t \tinsertSQLSplits_";
  protected final String TEXT_638 = " = insert_";
  protected final String TEXT_639 = ".split(\"\\\\?\");";
  protected final String TEXT_640 = NL + "        }";
  protected final String TEXT_641 = NL + "                commitEvery_";
  protected final String TEXT_642 = " = buffersSize_";
  protected final String TEXT_643 = ";";
  protected final String TEXT_644 = NL + "                batchSize_";
  protected final String TEXT_645 = " = buffersSize_";
  protected final String TEXT_646 = ";";
  protected final String TEXT_647 = NL + "            whetherReject_";
  protected final String TEXT_648 = " = false;";
  protected final String TEXT_649 = NL + "                        ";
  protected final String TEXT_650 = NL + "                        query_";
  protected final String TEXT_651 = " = ";
  protected final String TEXT_652 = ";";
  protected final String TEXT_653 = NL + "                    routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_654 = ",";
  protected final String TEXT_655 = ".";
  protected final String TEXT_656 = ", ";
  protected final String TEXT_657 = ",insertSQLSplits_";
  protected final String TEXT_658 = ");";
  protected final String TEXT_659 = NL + "                    DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_660 = ".";
  protected final String TEXT_661 = ", pstmt_";
  protected final String TEXT_662 = ", ";
  protected final String TEXT_663 = ", \"";
  protected final String TEXT_664 = "\");";
  protected final String TEXT_665 = NL + "                globalMap.put(\"";
  protected final String TEXT_666 = "_QUERY\", query_";
  protected final String TEXT_667 = ".toString().trim());";
  protected final String TEXT_668 = NL + "            pstmt_";
  protected final String TEXT_669 = ".addBatch();" + NL + "            nb_line_";
  protected final String TEXT_670 = "++;";
  protected final String TEXT_671 = NL + "                batchSizeCounter_";
  protected final String TEXT_672 = "++;";
  protected final String TEXT_673 = NL + "        try {" + NL + "            insertedCount_";
  protected final String TEXT_674 = " = insertedCount_";
  protected final String TEXT_675 = " + pstmt_";
  protected final String TEXT_676 = ".executeUpdate();" + NL + "            nb_line_";
  protected final String TEXT_677 = "++;";
  protected final String TEXT_678 = NL + "        } catch(java.lang.Exception e) {" + NL + "            whetherReject_";
  protected final String TEXT_679 = " = true;";
  protected final String TEXT_680 = NL + "        throw(e);";
  protected final String TEXT_681 = NL + "                ";
  protected final String TEXT_682 = " = new ";
  protected final String TEXT_683 = "Struct();";
  protected final String TEXT_684 = NL + "                    ";
  protected final String TEXT_685 = ".";
  protected final String TEXT_686 = " = ";
  protected final String TEXT_687 = ".";
  protected final String TEXT_688 = ";";
  protected final String TEXT_689 = NL + "                rejectedCount_";
  protected final String TEXT_690 = " = rejectedCount_";
  protected final String TEXT_691 = " + 1;";
  protected final String TEXT_692 = NL + "                ";
  protected final String TEXT_693 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_694 = NL + "                ";
  protected final String TEXT_695 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_696 = ";";
  protected final String TEXT_697 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_698 = NL + "    }";
  protected final String TEXT_699 = NL + "                    ";
  protected final String TEXT_700 = NL + "                        query_";
  protected final String TEXT_701 = " = ";
  protected final String TEXT_702 = ";";
  protected final String TEXT_703 = NL + "                    routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_704 = ",";
  protected final String TEXT_705 = ".";
  protected final String TEXT_706 = ", ";
  protected final String TEXT_707 = ",updateSQLSplits_";
  protected final String TEXT_708 = ");";
  protected final String TEXT_709 = NL + "                    int count_";
  protected final String TEXT_710 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_711 = ".";
  protected final String TEXT_712 = ", pstmt_";
  protected final String TEXT_713 = ", ";
  protected final String TEXT_714 = ", \"";
  protected final String TEXT_715 = "\");";
  protected final String TEXT_716 = NL;
  protected final String TEXT_717 = NL + "                           ";
  protected final String TEXT_718 = NL + "                           ";
  protected final String TEXT_719 = NL + "                                query_";
  protected final String TEXT_720 = " = ";
  protected final String TEXT_721 = ";";
  protected final String TEXT_722 = NL + "                                query_";
  protected final String TEXT_723 = " = ";
  protected final String TEXT_724 = ";";
  protected final String TEXT_725 = NL + "                    ";
  protected final String TEXT_726 = NL + "                            query_";
  protected final String TEXT_727 = " = ";
  protected final String TEXT_728 = ";";
  protected final String TEXT_729 = NL + "                            query_";
  protected final String TEXT_730 = " = ";
  protected final String TEXT_731 = ";";
  protected final String TEXT_732 = NL + "                globalMap.put(\"";
  protected final String TEXT_733 = "_QUERY\", query_";
  protected final String TEXT_734 = ".toString().trim());";
  protected final String TEXT_735 = NL;
  protected final String TEXT_736 = NL + "            pstmt_";
  protected final String TEXT_737 = ".addBatch();" + NL + "            nb_line_";
  protected final String TEXT_738 = "++;";
  protected final String TEXT_739 = NL + "            batchSizeCounter_";
  protected final String TEXT_740 = "++;";
  protected final String TEXT_741 = NL + "            try {" + NL + "                updatedCount_";
  protected final String TEXT_742 = " = updatedCount_";
  protected final String TEXT_743 = " + pstmt_";
  protected final String TEXT_744 = ".executeUpdate();" + NL + "                nb_line_";
  protected final String TEXT_745 = "++;";
  protected final String TEXT_746 = NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_747 = " = true;";
  protected final String TEXT_748 = NL + "                    throw(e);";
  protected final String TEXT_749 = NL + "                        ";
  protected final String TEXT_750 = " = new ";
  protected final String TEXT_751 = "Struct();";
  protected final String TEXT_752 = NL + "                            ";
  protected final String TEXT_753 = ".";
  protected final String TEXT_754 = " = ";
  protected final String TEXT_755 = ".";
  protected final String TEXT_756 = ";";
  protected final String TEXT_757 = NL + "                        rejectedCount_";
  protected final String TEXT_758 = " = rejectedCount_";
  protected final String TEXT_759 = " + 1;";
  protected final String TEXT_760 = NL + "                        ";
  protected final String TEXT_761 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_762 = NL + "                        ";
  protected final String TEXT_763 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_764 = ";";
  protected final String TEXT_765 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_766 = NL + "            }";
  protected final String TEXT_767 = NL + "                        ";
  protected final String TEXT_768 = NL + "                    ";
  protected final String TEXT_769 = NL + NL + "            java.sql.ResultSet rs_";
  protected final String TEXT_770 = " = pstmt_";
  protected final String TEXT_771 = ".executeQuery();" + NL + "            int checkCount_";
  protected final String TEXT_772 = " = -1;" + NL + "            while(rs_";
  protected final String TEXT_773 = ".next()) {" + NL + "                checkCount_";
  protected final String TEXT_774 = " = rs_";
  protected final String TEXT_775 = ".getInt(1);" + NL + "            }" + NL + "            if(checkCount_";
  protected final String TEXT_776 = " > 0) {";
  protected final String TEXT_777 = NL + "                        ";
  protected final String TEXT_778 = NL + "                            query_";
  protected final String TEXT_779 = " = ";
  protected final String TEXT_780 = ";";
  protected final String TEXT_781 = NL + "                            routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_782 = ",";
  protected final String TEXT_783 = ".";
  protected final String TEXT_784 = ", ";
  protected final String TEXT_785 = ",updateSQLSplits_";
  protected final String TEXT_786 = ");";
  protected final String TEXT_787 = NL + NL + "                        int count_";
  protected final String TEXT_788 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_789 = ".";
  protected final String TEXT_790 = ", pstmtUpdate_";
  protected final String TEXT_791 = ", ";
  protected final String TEXT_792 = ", \"";
  protected final String TEXT_793 = "\");";
  protected final String TEXT_794 = NL + "                            ";
  protected final String TEXT_795 = NL + "                            ";
  protected final String TEXT_796 = NL + "                                query_";
  protected final String TEXT_797 = " = ";
  protected final String TEXT_798 = ";";
  protected final String TEXT_799 = NL + "                                query_";
  protected final String TEXT_800 = " = ";
  protected final String TEXT_801 = ";";
  protected final String TEXT_802 = NL + "                        ";
  protected final String TEXT_803 = NL + "                            query_";
  protected final String TEXT_804 = " = ";
  protected final String TEXT_805 = ";";
  protected final String TEXT_806 = NL + "                            query_";
  protected final String TEXT_807 = " = ";
  protected final String TEXT_808 = ";";
  protected final String TEXT_809 = NL + "                    globalMap.put(\"";
  protected final String TEXT_810 = "_QUERY\", query_";
  protected final String TEXT_811 = ".toString().trim());";
  protected final String TEXT_812 = NL + "                try {" + NL + "                    updatedCount_";
  protected final String TEXT_813 = " = updatedCount_";
  protected final String TEXT_814 = " + pstmtUpdate_";
  protected final String TEXT_815 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_816 = "++;";
  protected final String TEXT_817 = NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_818 = " = true;";
  protected final String TEXT_819 = NL + "                        throw(e);";
  protected final String TEXT_820 = NL + "                        nb_line_";
  protected final String TEXT_821 = "++;";
  protected final String TEXT_822 = NL + "                            ";
  protected final String TEXT_823 = " = new ";
  protected final String TEXT_824 = "Struct();";
  protected final String TEXT_825 = NL + "                                ";
  protected final String TEXT_826 = ".";
  protected final String TEXT_827 = " = ";
  protected final String TEXT_828 = ".";
  protected final String TEXT_829 = ";";
  protected final String TEXT_830 = NL + "                            rejectedCount_";
  protected final String TEXT_831 = " = rejectedCount_";
  protected final String TEXT_832 = " + 1;";
  protected final String TEXT_833 = NL + "                            ";
  protected final String TEXT_834 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_835 = NL + "                            ";
  protected final String TEXT_836 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_837 = ";";
  protected final String TEXT_838 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_839 = NL + "                }" + NL + "            } else {";
  protected final String TEXT_840 = NL + "                        ";
  protected final String TEXT_841 = NL + "                            query_";
  protected final String TEXT_842 = " = ";
  protected final String TEXT_843 = ";";
  protected final String TEXT_844 = NL + "                        routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_845 = ",";
  protected final String TEXT_846 = ".";
  protected final String TEXT_847 = ", ";
  protected final String TEXT_848 = ",insertSQLSplits_";
  protected final String TEXT_849 = ");";
  protected final String TEXT_850 = NL + "                        DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_851 = ".";
  protected final String TEXT_852 = ", pstmtInsert_";
  protected final String TEXT_853 = ", ";
  protected final String TEXT_854 = ", \"";
  protected final String TEXT_855 = "\");";
  protected final String TEXT_856 = NL + "                    globalMap.put(\"";
  protected final String TEXT_857 = "_QUERY\", query_";
  protected final String TEXT_858 = ".toString().trim());";
  protected final String TEXT_859 = NL + "                try {" + NL + "                    insertedCount_";
  protected final String TEXT_860 = " = insertedCount_";
  protected final String TEXT_861 = " + pstmtInsert_";
  protected final String TEXT_862 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_863 = "++;";
  protected final String TEXT_864 = NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_865 = " = true;";
  protected final String TEXT_866 = NL + "                        throw(e);";
  protected final String TEXT_867 = NL + "                        nb_line_";
  protected final String TEXT_868 = "++;";
  protected final String TEXT_869 = NL + "                            ";
  protected final String TEXT_870 = " = new ";
  protected final String TEXT_871 = "Struct();";
  protected final String TEXT_872 = NL + "                                ";
  protected final String TEXT_873 = ".";
  protected final String TEXT_874 = " = ";
  protected final String TEXT_875 = ".";
  protected final String TEXT_876 = ";";
  protected final String TEXT_877 = NL + "                            rejectedCount_";
  protected final String TEXT_878 = " = rejectedCount_";
  protected final String TEXT_879 = " + 1;";
  protected final String TEXT_880 = NL + "                            ";
  protected final String TEXT_881 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_882 = NL + "                            ";
  protected final String TEXT_883 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_884 = ";";
  protected final String TEXT_885 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_886 = NL + "                }" + NL + "            }";
  protected final String TEXT_887 = NL + "            int updateFlag_";
  protected final String TEXT_888 = " = 0;";
  protected final String TEXT_889 = NL + "                    ";
  protected final String TEXT_890 = NL + "                        query_";
  protected final String TEXT_891 = " = ";
  protected final String TEXT_892 = ";";
  protected final String TEXT_893 = NL + "                        routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_894 = ",";
  protected final String TEXT_895 = ".";
  protected final String TEXT_896 = ", ";
  protected final String TEXT_897 = ",updateSQLSplits_";
  protected final String TEXT_898 = ");";
  protected final String TEXT_899 = NL + NL + "                    int count_";
  protected final String TEXT_900 = "=DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_901 = ".";
  protected final String TEXT_902 = ", pstmtUpdate_";
  protected final String TEXT_903 = ", ";
  protected final String TEXT_904 = ", \"";
  protected final String TEXT_905 = "\");";
  protected final String TEXT_906 = NL + "                        ";
  protected final String TEXT_907 = NL + "                        ";
  protected final String TEXT_908 = NL + "                            query_";
  protected final String TEXT_909 = " = ";
  protected final String TEXT_910 = ";";
  protected final String TEXT_911 = NL + "                            query_";
  protected final String TEXT_912 = " = ";
  protected final String TEXT_913 = ";";
  protected final String TEXT_914 = NL + "                    ";
  protected final String TEXT_915 = NL + "                        query_";
  protected final String TEXT_916 = " = ";
  protected final String TEXT_917 = ";";
  protected final String TEXT_918 = NL + "                        query_";
  protected final String TEXT_919 = " = ";
  protected final String TEXT_920 = ";";
  protected final String TEXT_921 = NL + "                globalMap.put(\"";
  protected final String TEXT_922 = "_QUERY\", query_";
  protected final String TEXT_923 = ".toString().trim());";
  protected final String TEXT_924 = NL + NL + "            try {" + NL + "                updateFlag_";
  protected final String TEXT_925 = "=pstmtUpdate_";
  protected final String TEXT_926 = ".executeUpdate();" + NL + "                updatedCount_";
  protected final String TEXT_927 = " = updatedCount_";
  protected final String TEXT_928 = " + updateFlag_";
  protected final String TEXT_929 = ";" + NL + "            if(updateFlag_";
  protected final String TEXT_930 = " == 0) {";
  protected final String TEXT_931 = NL + "                query_";
  protected final String TEXT_932 = " = new StringBuffer(\"\");";
  protected final String TEXT_933 = NL + "                        ";
  protected final String TEXT_934 = NL + "                            query_";
  protected final String TEXT_935 = " = ";
  protected final String TEXT_936 = ";";
  protected final String TEXT_937 = NL + "                            routines.system.DynamicUtils.debugDynamicSql(query_";
  protected final String TEXT_938 = ",";
  protected final String TEXT_939 = ".";
  protected final String TEXT_940 = ", ";
  protected final String TEXT_941 = ",insertSQLSplits_";
  protected final String TEXT_942 = ");";
  protected final String TEXT_943 = NL + "                        DynamicUtils.writeColumnsToDatabse(";
  protected final String TEXT_944 = ".";
  protected final String TEXT_945 = ", pstmtInsert_";
  protected final String TEXT_946 = ", ";
  protected final String TEXT_947 = ", \"";
  protected final String TEXT_948 = "\");";
  protected final String TEXT_949 = NL + "                    globalMap.put(\"";
  protected final String TEXT_950 = "_QUERY\", query_";
  protected final String TEXT_951 = ".toString().trim());";
  protected final String TEXT_952 = NL + "                    insertedCount_";
  protected final String TEXT_953 = " = insertedCount_";
  protected final String TEXT_954 = " + pstmtInsert_";
  protected final String TEXT_955 = ".executeUpdate();" + NL + "                    nb_line_";
  protected final String TEXT_956 = "++;";
  protected final String TEXT_957 = NL + "                }else{" + NL + "                    nb_line_";
  protected final String TEXT_958 = "++;";
  protected final String TEXT_959 = NL + "                }" + NL + "                } catch(java.lang.Exception e) {" + NL + "                    whetherReject_";
  protected final String TEXT_960 = " = true;";
  protected final String TEXT_961 = NL + "                        throw(e);";
  protected final String TEXT_962 = NL + "                        nb_line_";
  protected final String TEXT_963 = "++;";
  protected final String TEXT_964 = NL + "                            ";
  protected final String TEXT_965 = " = new ";
  protected final String TEXT_966 = "Struct();";
  protected final String TEXT_967 = NL + "                                ";
  protected final String TEXT_968 = ".";
  protected final String TEXT_969 = " = ";
  protected final String TEXT_970 = ".";
  protected final String TEXT_971 = ";";
  protected final String TEXT_972 = NL + "                            rejectedCount_";
  protected final String TEXT_973 = " = rejectedCount_";
  protected final String TEXT_974 = " + 1;";
  protected final String TEXT_975 = NL + "                            ";
  protected final String TEXT_976 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_977 = NL + "                            ";
  protected final String TEXT_978 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_979 = ";";
  protected final String TEXT_980 = NL + "                            System.err.print(e.getMessage());";
  protected final String TEXT_981 = NL + "                }";
  protected final String TEXT_982 = NL + "                        ";
  protected final String TEXT_983 = NL + "                            query_";
  protected final String TEXT_984 = " = ";
  protected final String TEXT_985 = ";";
  protected final String TEXT_986 = NL + "                    ";
  protected final String TEXT_987 = NL + "                        query_";
  protected final String TEXT_988 = " = ";
  protected final String TEXT_989 = ";";
  protected final String TEXT_990 = NL + "                globalMap.put(\"";
  protected final String TEXT_991 = "_QUERY\", query_";
  protected final String TEXT_992 = ".toString().trim());";
  protected final String TEXT_993 = NL + "            pstmt_";
  protected final String TEXT_994 = ".addBatch();" + NL + "            nb_line_";
  protected final String TEXT_995 = "++;";
  protected final String TEXT_996 = NL + "            batchSizeCounter_";
  protected final String TEXT_997 = "++;";
  protected final String TEXT_998 = NL + "            try {" + NL + "                deletedCount_";
  protected final String TEXT_999 = " = deletedCount_";
  protected final String TEXT_1000 = " + pstmt_";
  protected final String TEXT_1001 = ".executeUpdate();" + NL + "                nb_line_";
  protected final String TEXT_1002 = "++;";
  protected final String TEXT_1003 = NL + "            } catch(java.lang.Exception e) {" + NL + "                whetherReject_";
  protected final String TEXT_1004 = " = true;";
  protected final String TEXT_1005 = NL + "                    throw(e);";
  protected final String TEXT_1006 = NL + "                    nb_line_";
  protected final String TEXT_1007 = "++;";
  protected final String TEXT_1008 = NL + "                        ";
  protected final String TEXT_1009 = " = new ";
  protected final String TEXT_1010 = "Struct();";
  protected final String TEXT_1011 = NL + "                            ";
  protected final String TEXT_1012 = ".";
  protected final String TEXT_1013 = " = ";
  protected final String TEXT_1014 = ".";
  protected final String TEXT_1015 = ";";
  protected final String TEXT_1016 = NL + "                        rejectedCount_";
  protected final String TEXT_1017 = " = rejectedCount_";
  protected final String TEXT_1018 = " + 1;";
  protected final String TEXT_1019 = NL + "                        ";
  protected final String TEXT_1020 = ".errorCode = ((java.sql.SQLException)e).getSQLState();";
  protected final String TEXT_1021 = NL + "                        ";
  protected final String TEXT_1022 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1023 = ";";
  protected final String TEXT_1024 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_1025 = NL + "            }";
  protected final String TEXT_1026 = NL + "            if(!whetherReject_";
  protected final String TEXT_1027 = ") {";
  protected final String TEXT_1028 = NL + "                            ";
  protected final String TEXT_1029 = " = new ";
  protected final String TEXT_1030 = "Struct();";
  protected final String TEXT_1031 = NL + "                                ";
  protected final String TEXT_1032 = ".";
  protected final String TEXT_1033 = " = ";
  protected final String TEXT_1034 = ".";
  protected final String TEXT_1035 = ";";
  protected final String TEXT_1036 = NL + "            }";
  protected final String TEXT_1037 = NL + "                if ((batchSize_";
  protected final String TEXT_1038 = " > 0) && (batchSize_";
  protected final String TEXT_1039 = " <= batchSizeCounter_";
  protected final String TEXT_1040 = ")) {" + NL + "                try {";
  protected final String TEXT_1041 = NL + "                        pstmt_";
  protected final String TEXT_1042 = ".executeBatch();";
  protected final String TEXT_1043 = NL + "                        java.io.ByteArrayInputStream bais_";
  protected final String TEXT_1044 = " = new ByteArrayInputStream(stmtBuilder_";
  protected final String TEXT_1045 = ".toString().getBytes());";
  protected final String TEXT_1046 = NL + "                            com.vertica.jdbc.VerticaCopyStream vcs_";
  protected final String TEXT_1047 = " = new com.vertica.jdbc.VerticaCopyStream((com.vertica.jdbc.VerticaConnection)conn_";
  protected final String TEXT_1048 = ",template_";
  protected final String TEXT_1049 = ");" + NL + "                            vcs_";
  protected final String TEXT_1050 = ".start();" + NL + "                            vcs_";
  protected final String TEXT_1051 = ".addStream(bais_";
  protected final String TEXT_1052 = ");" + NL + "                            vcs_";
  protected final String TEXT_1053 = ".execute();" + NL + "                            vcs_";
  protected final String TEXT_1054 = ".finish();";
  protected final String TEXT_1055 = NL + "                            ((com.vertica.PGStatement)stmt_";
  protected final String TEXT_1056 = ").executeCopyIn(template_";
  protected final String TEXT_1057 = ", bais_";
  protected final String TEXT_1058 = ");";
  protected final String TEXT_1059 = NL + "                        stmtBuilder_";
  protected final String TEXT_1060 = " = null;" + NL + "                        if (bais_";
  protected final String TEXT_1061 = " != null) {" + NL + "                            bais_";
  protected final String TEXT_1062 = ".close();" + NL + "                            bais_";
  protected final String TEXT_1063 = " = null;" + NL + "                        }" + NL + "                        stmtBuilder_";
  protected final String TEXT_1064 = " = new StringBuilder();";
  protected final String TEXT_1065 = NL + "                            insertedCount_";
  protected final String TEXT_1066 = " += pstmt_";
  protected final String TEXT_1067 = ". getUpdateCount();";
  protected final String TEXT_1068 = NL + "                            updatedCount_";
  protected final String TEXT_1069 = " += pstmt_";
  protected final String TEXT_1070 = ". getUpdateCount();";
  protected final String TEXT_1071 = NL + "                            deletedCount_";
  protected final String TEXT_1072 = " += pstmt_";
  protected final String TEXT_1073 = ". getUpdateCount();";
  protected final String TEXT_1074 = NL + "                                copiedCount_";
  protected final String TEXT_1075 = " += vcs_";
  protected final String TEXT_1076 = ".getRowCount();";
  protected final String TEXT_1077 = NL + "                                copiedCount_";
  protected final String TEXT_1078 = " += stmt_";
  protected final String TEXT_1079 = ".getUpdateCount();";
  protected final String TEXT_1080 = NL + "                        batchSizeCounter_";
  protected final String TEXT_1081 = " = 0;" + NL + "                }catch (java.sql.SQLException e){";
  protected final String TEXT_1082 = NL + "                        throw(e);";
  protected final String TEXT_1083 = NL + "                    System.err.println(e.getMessage());";
  protected final String TEXT_1084 = NL + "                }" + NL + "            }";
  protected final String TEXT_1085 = NL + "                commitCounter_";
  protected final String TEXT_1086 = "++;" + NL + "                if(commitEvery_";
  protected final String TEXT_1087 = " <= commitCounter_";
  protected final String TEXT_1088 = ") {" + NL;
  protected final String TEXT_1089 = NL + "                try {";
  protected final String TEXT_1090 = NL + "                            boolean isCountResult_";
  protected final String TEXT_1091 = " = false;" + NL + "                            if(batchSizeCounter_";
  protected final String TEXT_1092 = " > 0){";
  protected final String TEXT_1093 = NL + "                                pstmt_";
  protected final String TEXT_1094 = ".executeBatch();";
  protected final String TEXT_1095 = NL + "                                isCountResult_";
  protected final String TEXT_1096 = " = true;" + NL + "                                batchSizeCounter_";
  protected final String TEXT_1097 = " = 0;" + NL + "                            }";
  protected final String TEXT_1098 = NL + "                        if(isCountResult_";
  protected final String TEXT_1099 = "){";
  protected final String TEXT_1100 = NL + "                        insertedCount_";
  protected final String TEXT_1101 = " += pstmt_";
  protected final String TEXT_1102 = ".getUpdateCount();";
  protected final String TEXT_1103 = NL + "                        updatedCount_";
  protected final String TEXT_1104 = " += pstmt_";
  protected final String TEXT_1105 = ".getUpdateCount();";
  protected final String TEXT_1106 = NL + "                        deletedCount_";
  protected final String TEXT_1107 = " += pstmt_";
  protected final String TEXT_1108 = ".getUpdateCount();";
  protected final String TEXT_1109 = NL + "                        }";
  protected final String TEXT_1110 = NL + "                        if (stmtBuilder_";
  protected final String TEXT_1111 = " != null && stmtBuilder_";
  protected final String TEXT_1112 = ".length() != 0 ) { // stmtBuilder_";
  protected final String TEXT_1113 = " start" + NL + "                            java.io.ByteArrayInputStream bais_";
  protected final String TEXT_1114 = " = new ByteArrayInputStream(stmtBuilder_";
  protected final String TEXT_1115 = ".toString().getBytes());";
  protected final String TEXT_1116 = NL + "                            ((com.vertica.PGStatement)stmt_";
  protected final String TEXT_1117 = ").executeCopyIn(template_";
  protected final String TEXT_1118 = ", bais_";
  protected final String TEXT_1119 = ");";
  protected final String TEXT_1120 = NL + "                            stmtBuilder_";
  protected final String TEXT_1121 = " = null;" + NL + "                            if (bais_";
  protected final String TEXT_1122 = " != null) {" + NL + "                                bais_";
  protected final String TEXT_1123 = ".close();" + NL + "                                bais_";
  protected final String TEXT_1124 = " = null;" + NL + "                            }" + NL + "                            stmtBuilder_";
  protected final String TEXT_1125 = " = new StringBuilder();" + NL + "                            copiedCount_";
  protected final String TEXT_1126 = " += stmt_";
  protected final String TEXT_1127 = ".getUpdateCount();" + NL + "                        } // stmtBuilder_";
  protected final String TEXT_1128 = " end";
  protected final String TEXT_1129 = NL + "                }catch (java.sql.SQLException e){";
  protected final String TEXT_1130 = NL + "                        throw(e);";
  protected final String TEXT_1131 = NL + "                        System.err.println(e.getMessage());";
  protected final String TEXT_1132 = NL + NL + "                }";
  protected final String TEXT_1133 = NL + "                    conn_";
  protected final String TEXT_1134 = ".commit();";
  protected final String TEXT_1135 = NL + "                    commitCounter_";
  protected final String TEXT_1136 = "=0;" + NL + "                }";
  protected final String TEXT_1137 = NL;

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
    public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String REDSHIFT = "redshift_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        
        boolean isDynamic = false;
        
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
            if(this.getColumn()!=null) {
                if (this.getColumn().getTalendType().equals("id_Geometry")) {
                    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
                        return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
                    return this.sqlStmt;
                }
            } else {
                return this.sqlStmt;
            }
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
        
        public boolean isDynamic() {
            return isDynamic;
        }
        
        public void setDynamic(boolean isDynamic) {
            this.isDynamic = isDynamic;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient
        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
          return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
          return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if("oracle_id".equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                                String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                                int index = pkList.indexOf(columnStr);
                                if(index !=-1){
                                    for (int i=index;i>0;i--) {
                                        pkList.set(i, pkList.get(i-1));
                                    }
                                    pkList.set(0, columnStr);
                                }
                            }
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        protected String getAutoIncrement(int startValue, int step) {
            if("sybase_id".equalsIgnoreCase(getDBMSId())){
                return " IDENTITY NOT NULL";
            } else if("mysql_id".equalsIgnoreCase(getDBMSId()) ) {
                return " AUTO_INCREMENT";
            } else if("ibmdb2_id".equalsIgnoreCase(getDBMSId())){
                return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
            } else {
                return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
            }
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.name.equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        
        private boolean dynamicColumnIsReplaced = false;
        
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
                
                Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
                skeletonColumn.setOperator("=");
                skeletonColumn.setDataType(column.getType());
                stmtStructure.add(skeletonColumn);
                
                if("id_Dynamic".equals(column.getTalendType())) {
                    skeletonColumn.setDynamic(true);
                }
            }
            
            dynamicColumnIsReplaced = false;
            
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                                
                                if(replacedCol.isDynamic()) {
                                    dynamicColumnIsReplaced = true;
                                }
                            }                            
                        }
                    }
                }
            }
            
            return stmtStructure;
        }
        
        public boolean isDynamicColumnReplaced() {
            return dynamicColumnIsReplaced;
        }
        
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
                actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
                actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
                for(Column column : stmtStructure) {
                    if(column.isReplaced()) {
                        List<Column> replacedColumns = column.getReplacement();
                        for(Column replacedColumn : replacedColumns) {
                            actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
                        }
                    } else {
                        actionSQLMap = processSQLClause(column, actionSQLMap);        
                    }
                }
            }
            return actionSQLMap;
        }
        
        private boolean isSpecifyIdentityKey = false;
        
        public void setIsSpecifyIdentityKey(boolean isSpecifyIdentityKey) {
            this.isSpecifyIdentityKey = isSpecifyIdentityKey;
        }
        
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            String identityKey = ElementParameterParser.getValue(node, "__IDENTITY_FIELD__");
            if(!(isSpecifyIdentityKey && (column.getName().equals(identityKey))) && column.isInsertable() && !column.isDynamic()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable() && !column.isDynamic()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey() && !column.isDynamic()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey() && !column.isDynamic()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit);
        }
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                    if (index == 1 && dynCol == null) {
                        return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                    } else {
                        return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                    }
            }else {
                if (index == 1 && dynCol == null) {
                    return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                } else {
                    return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                }
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit, replaceFixedStr);
        }
        
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if (index == 1 && dynCol == null) {
                return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
            } else {
                return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+dynamicIndex+"])";
            }
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + dynamicIndex + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(null, column, index, incomingConnName, cid, actionType);
        }     
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
                String fieldDelimiter, 
                String newLineChar,
                String nullIndicator) {
        return null;
            
        }
        
        public String generateCode4TabelExist() {
            boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
            String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
            StringBuilder code = new StringBuilder();  
            code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
            if (hasSchema()) {
                code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
                code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("} else {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("}\r\n");
            }
            return code.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }

        /*
         * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
         * this because of some db default add getLProtectedChar() and getRProtectedChar() to schaem when create table. e.g:db2
         * 
         * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
        */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }   
        
        protected boolean hasSchema() {
            return false;
        }
        
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                if (typeToGenerate.equals("Long")) {
                    setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            
            // add VectorWise option
            if ("vectorwise_id".equalsIgnoreCase(getDBMSId())){
                createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
        String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class HiveManager extends Manager {
        String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
        boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
            this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
                String recordDelimiter, String nullIndicator) {     
            StringBuilder copyBulkSQL = new StringBuilder();
            copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            copyBulkSQL.append(" (\"+");                
            int counter = 0;
            for(IMetadataColumn column : columnList) {
                counter++;
                // add each table field and separator
                copyBulkSQL.append( 
                "\n\"\\n" +
                  column.getOriginalDbColumnName() 
                + "="
                + (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
            
                // add these only if not last entry
                if (counter < columnList.size()){
                    copyBulkSQL.append(
                    //convertDelim(fieldDelimiter)
                    "\"+field_delimiter_"+cid +"+\""
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    + " ,"
                    + "\""
                    + "+"
                    );
                } else {
                    copyBulkSQL.append(
                    recordDelimiter
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    );
                    copyBulkSQL.append(")");
                }       
            } 
            return copyBulkSQL.toString();
        } 

        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
            + cid + " + \"\\\" TO TRUNCATED");
            return truncateTableSQL.toString();
        }                       
    }
    
    public class VectorWiseManager extends IngresManager {
        public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
    }   
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
            return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + dynamicIndex + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                    MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
                    dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                boolean isMSSQL = "id_MSSQL".equals(this.getDBMSId());
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){                    
                    String pattern = column.getColumn().getPattern();
                    setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                    if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                    }
                    setStmt.append("}else{\r\n");
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                    setStmt.append("}\r\n");
                }else if(isMSSQL && "TIME".equals(dbType)){//TDI-30431 begin
                    String timePattern = column.getColumn().getPattern();
                    //Compatible with Time,Date and String,it will fail if Time contain fractional seconds.(Solution:Use sqljdbc.jar and setTime() instead)
                    //setStmt.append(prefix + cid + ".setString(" + index + dynamic + "," + incomingConnName + "." + column.getName()+".toString()");// For Time and String
                    setStmt.append(prefix + cid + ".setString(" + index + dynamic + ","
                                    + incomingConnName + "." + column.getName()
                                    +" instanceof java.util.Date ? new java.text.SimpleDateFormat("+timePattern+").format("
                                    + incomingConnName + "." + column.getName()+") : "
                                    + incomingConnName + "." + column.getName()+".toString()");//Compatible with tFileInputDelimiter Date Type and Time and String
                    setStmt.append(");\r\n");
                }else{//TDI-30431 end
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                setStmt.append("} else {");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
          private String[] oracleKeyWords= {
                    "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                    "ADD","CONNECT","DISTINCT" ,
                    "ALL","BY","CREATE","DROP",
                    "ALTER","CHAR","CURRENT","ELSE",
                    "AND","CHECK","DATE","EXCLUSIVE",
                    "ANY","CLUSTER","DECIMAL"," EXISTS",
                    "AS","COLUMN","DEFAULT","FILE",
                    "ASC","COMMENT","DELETE","FLOAT",
                    "FOR","LONG","PCTFREE","SUCCESSFUL",
                    "FROM","MAXEXTENTS","PRIOR","SYNONYM",
                    "GRANT","MINUS","PRIVILEGES","SYSDATE",
                    "GROUP","MODE","PUBLIC","TABLE",
                    "HAVING","MODIFY","RAW","THEN",
                    "IDENTIFIED","NETWORK","RENAME","TO",
                    "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                    "IN","NOCOMPRESS","REVOKE","UID",
                    "INCREMENT","NOT","ROW","UNION",
                    "INDEX","NOWAIT","ROWID","UNIQUE",
                    "INITIAL","NULL","ROWNUM","UPDATE",
                    "INSERT","NUMBER","ROWS","USER",
                    "INTEGER","OF","SELECT","VALIDATE",
                    "INTERSECT","OFFLINE","SESSION","VALUES",
                    "INTO","ON","SET","VARCHAR",
                    "IS","ONLINE","SHARE","VARCHAR2",
                    "LEVEL","OPTION","SIZE","VIEW",
                    "LIKE","OR","SMALLINT","WHENEVER",
                    "LOCK","ORDER","START","WHERE","WITH"
                    };
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
                    setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
                    setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + dynamic +  ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
                    setStmt.append("}else{");
                    setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    setStmt.append("}");
                }else if ("Date".equalsIgnoreCase(dbType)) {
                    if (!"true".equals(ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__"))) {
                        setStmt.append(prefix + cid + ".setDate(" + index + dynamic +  ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    } else {
                        setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    }
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic +  ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic +  ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic +  ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && (dbType.equals("XMLTYPE")||dbType.equals("CLOB")))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  clobTypeUtil_" + cid + ".getCLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  blobTypeUtil_" + cid + ".getBLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
            if(convertToUppercase){
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
            }else{
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
            }
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
            String columnName = column.getColumnName();
            String dataType = column.getDataType();
            if(dataType!=null)
            {
            boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
            if(trimChar && "char".equals(dataType.toLowerCase()))
            {
                columnName = "trim("+columnName+")";
            }
            }
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class RedshiftManager extends PostgreManager {
         public RedshiftManager(String cid) {
             super(cid);
         }
         
         protected String getDBMSId() {
             return REDSHIFT;
         }
         
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                if (column.getColumn().getLength() == null) {                                  
                                } else { 
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + length);                                    
                                }
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            if (column.getColumn().getLength() == null) {
                            } else {
                                createSQL.append(suffix);
                            }
                        }
                            
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class GreenplumManager extends PostgrePlusManager {
         public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
         private String[] sybaseKeyWords= {
                 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                "ADD","CONNECT","COUNT","DISTINCT" ,
                "ALL","BY","CREATE","DROP",
                "ALTER","CHAR","CURRENT","ELSE",
                "AND","CHECK","DATE","EXCLUSIVE",
                "ANY","CLUSTER","DECIMAL"," EXISTS",
                "AS","COLUMN","DEFAULT","FILE",
                "ASC","COMMENT","DELETE","FLOAT",
                "FOR","LONG","PCTFREE","SUCCESSFUL",
                "FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
                "GRANT","MINUS","PRIVILEGES","SYSDATE",
                "GROUP","MODE","PUBLIC","TABLE",
                "HAVING","MODIFY","RAW","THEN",
                "IDENTIFIED","NETWORK","RENAME","TO",
                "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                "IN","NOCOMPRESS","REVOKE","UID",
                "INCREMENT","NOT","ROW","UNION",
                "INDEX","NOWAIT","ROWID","UNIQUE",
                "INITIAL","NULL","ROWNUM","UPDATE",
                "INSERT","NUMBER","ROWS","USER",
                "INTEGER","OF","SELECT","VALIDATE",
                "INTERSECT","OFFLINE","SESSION","VALUES",
                "INTO","ON","SET","VARCHAR",
                "IS","ONLINE","SHARE",
                "LEVEL","OPTION","SIZE","VIEW",
                "LIKE","OR","SMALLINT","WHENEVER",
                "LOCK","ORDER","START","WHERE","WITH"
                 
         };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal")){
                if(column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                    setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
                    setStmt.append("} else {\r\n");
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                    setStmt.append("}\r\n");
                }else{
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
                
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BINARY);\r\n");                
                }
            } else if(typeToGenerate.equals("Byte")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TINYINT);\r\n");                
            } else if(typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.SMALLINT);\r\n");                
            } else if(typeToGenerate.equals("Long")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BIGINT);\r\n");                
            } else if(typeToGenerate.equals("Integer")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if ((typeToGenerate.equals("String")) && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new java.io.ByteArrayInputStream(" + incomingConnName + "." + column.getName() + ".toString().getBytes()), (" + incomingConnName + "." + column.getName() + ".toString().getBytes()).length);\r\n");                
            } else if ((typeToGenerate.equals("Bytes")) && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");    
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if ("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( ("oracle_id".equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (("mysql_id".equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if (("postgres_id".equalsIgnoreCase(getDBMSId()) || "postgresplus_id".equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if("mysql_id".equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            String table_type = ElementParameterParser.getValue(node,"__TABLE_TYPE__");
            createSQL.append("CREATE "+table_type+" TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + length);                                    
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            createSQL.append(suffix);
                        }                            
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }    
    
    public class ExasolManager extends Manager{
        public ExasolManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }  
   }
    public class UnDefinedManager extends Manager{
        
        private String dbmsId = "";
        
        public UnDefinedManager(String cid) {
            super(cid);
        }
        public void setDBMSId(String dbmsId){
            this.dbmsId = dbmsId;
        }
        protected String getDBMSId() {
            return this.dbmsId;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                columnList = metadata.getListColumns();
                if(metadata.isDynamicSchema() && columnList!=null) {
                    for(int i=columnList.size()-1; i>-1; i--) {
                        IMetadataColumn column = columnList.get(i);
                        if("id_Dynamic".equals(column.getTalendType())){
                            talendDynamicColumn = column;
                            break;
                        }
                    }
                }
            }
        }
        return columnList;
    }
    
    private IMetadataColumn talendDynamicColumn = null;
    
    public IMetadataColumn getDynamicColumn() {
        return talendDynamicColumn;
    }
    
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
    
class DBConnLogUtil extends BasicLogUtil{
	
	private DBConnLogUtil(){}
	
	protected DBConnLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logJDBCDriver(String driverClass){
		debug(str("Driver ClassName: "), driverClass, str("."));
	}
	
	public void connTry(String url, String dbUser){
		if(dbUser != null){
			info(str("Connection attempts to '"), url, str("' with the username '"), dbUser, str("'."));
		}else{
			info(str("Connection attempts to '"), url, str("'."));
		}
	}
	
	public void connDone(String url){
		info(str("Connection to '"), url, str("' has succeeded."));
	}
	
	public void useExistConn(String url, String dbUser){
		if(dbUser != null){
			info(str("Uses an existing connection with username '"), dbUser, str("'. Connection URL: "), url, str("."));
		}else{
			info(str("Uses an existing connection. Connection URL: "), url, str("."));
		}
	}
	
	public void closeTry(String connCompID){
		if(connCompID == null){
			info(str("Closing the connection to the database."));
		}else{
			info(str("Closing the connection "), connCompID, str(" to the database."));
		}
	}
	
	public void closeDone(String connCompID){
		if(connCompID == null){
			info(str("Connection to the database has closed."));	
		}else{
			info(str("Connection "), connCompID, str(" to the database has closed."));
		}
	}
}

class DBTableActionLogUtil extends BasicLogUtil{
	private DBTableActionLogUtil(){}
	
	protected DBTableActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void dropTry(String tableName){
		tableActionTry(tableName, str("Dropping"));
	}
	
	public void dropDone(String tableName){
		tableActionDone(tableName, str("Drop"));
	}
	
	public void createTry(String tableName){
		tableActionTry(tableName, str("Creating"));
	}
	
	public void createDone(String tableName){
		tableActionDone(tableName, str("Create"));
	}
	
	public void clearTry(String tableName){
		tableActionTry(tableName, str("Clearing"));
	}
	
	public void clearDone(String tableName){
		tableActionDone(tableName, str("Clear"));
	}
	
	public void truncateTry(String tableName){
		tableActionTry(tableName, str("Truncating"));
	}
	
	public void truncateDone(String tableName){
		tableActionDone(tableName, str("Truncate"));
	}
	
	public void truncateReuseStorageTry(String tableName){
		tableActionTry(tableName, str("Truncating reuse storage"));
	}
	
	public void truncateReuseStorageDone(String tableName){
		tableActionDone(tableName, str("Truncate reuse stroage"));
	}
	
	private void tableActionTry(String tableName, String action){
		info(action, str(" table '"), tableName, str("'."));
	}
	
	private void tableActionDone(String tableName, String action){
		info(action, str(" table '"), tableName, str("' has succeeded."));
	}
}

class DBCommitLogUtil extends BasicLogUtil{
	private DBCommitLogUtil(){}
	
	protected DBCommitLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logAutoCommit(String autoCommit){
		debug(str("Connection is set auto commit to '"), autoCommit, str("'."));
	}

	public void commitTry(String connCompID, String commitCount){
		if(commitCount == null && connCompID == null){
			debug(str("Connection starting to commit."));
		}else if(commitCount == null){
			debug(str("Connection "), connCompID, str(" starting to commit."));	
		}else if(connCompID == null){
			debug(str("Connection starting to commit "), commitCount, str(" record(s)."));
		}else{
			debug(str("Connection "), connCompID, str(" starting to commit "), commitCount, str(" record(s)."));
		}
	}
	
	public void commitDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection commit has succeeded."));
		}else{
			debug(str("Connection "), connCompID, (" commit has succeeded."));
		}
	}
}

class DBBatchLogUtil extends BasicLogUtil{
	private DBBatchLogUtil(){}
	
	protected DBBatchLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void executeTry(String action){
		debug(str("Executing the "), action, str(" batch."));
	}
	
	public void executeDone(String action){
		debug(str("The "), action, str(" batch execution has succeeded."));
	}
}

class DBDataActionLogUtil extends BasicLogUtil{
	private DBDataActionLogUtil(){}
	
	protected DBDataActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void inserting(String nbline){
		sqlAction(nbline, str("Inserting"));
	}
	
	public void deleting(String nbline){
		sqlAction(nbline, str("Deleting"));
	}
	
	public void updating(String nbline){
		sqlAction(nbline, str("Updating"));
	}
	
	public void replacing(String nbline){
		sqlAction(nbline, str("Replacing"));
	}
	
	public void insertingOnDuplicateKeyUpdating(String nbline){
		sqlAction(nbline, str("Inserting on duplicate key updating"));
	}
	
	public void insertingIgnore(String nbline){
		sqlAction(nbline, str("Inserting ignore"));
	}
	
	private void sqlAction(String nbline, String action){
		if(nbline == null){
			debug(action, str(" the record."));
		}else{
			debug(action, str(" the record "), nbline, str("."));
		}
	}
	
	public void sqlExecuteTry(String sql){
		debug(str("Executing '"), sql, str("'."));
	}
	
	public void sqlExecuteDone(String sql){
		debug(str("Execute '"), sql, str("' has succeeded."));
	}

	public void addingToBatch(String nbline, String batchAction){
		debug(str("Adding the record "), nbline, str(" to the "), batchAction, str(" batch."));
	}
}

class DBStateLogUtil extends BasicLogUtil{
	private DBStateLogUtil(){}
	
	protected DBStateLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logInsertedLines(String nbline){
		logFinishedLines(nbline, str("inserted"));
	}
	
	public void logUpdatedLines(String nbline){
		logFinishedLines(nbline, str("updated"));
	}
	
	public void logDeletedLines(String nbline){
		logFinishedLines(nbline, str("deleted"));
	}
	
	public void logRejectedLines(String nbline){
		logFinishedLines(nbline, str("rejected"));
	}
	
	private void logFinishedLines(String nbline, String action){
		info(str("Has "), action, str(" "), nbline, str(" record(s)."));
	}
}	
class DBLogUtil extends LogUtil{
	DBConnLogUtil conn = null;
	DBTableActionLogUtil table = null;
	DBCommitLogUtil commit = null;
	DBBatchLogUtil batch = null;
	DBDataActionLogUtil data = null;
	DBStateLogUtil state = null;
	private DBLogUtil(){}
	
	protected DBLogUtil(org.talend.core.model.process.INode node){
		super(node);
		conn = new DBConnLogUtil(node);
    	table = new DBTableActionLogUtil(node);
    	commit = new DBCommitLogUtil(node);
    	batch = new DBBatchLogUtil(node);
    	data = new DBDataActionLogUtil(node);
    	state = new DBStateLogUtil(node);
	}
	
	public DBConnLogUtil conn(){
		return conn;
	}
	
	public DBTableActionLogUtil table(){
		return table;
	}
	
	public DBCommitLogUtil commit(){
		return commit;
	}
	
	public DBBatchLogUtil batch(){
		return batch;
	}
	
	public DBDataActionLogUtil data(){
		return data;
	}
	
	public DBStateLogUtil state(){
		return state;
	}
}
DBLogUtil dbLog = null;

    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();

    dbLog = new DBLogUtil(node);

    final String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    String tableName = ElementParameterParser.getValue(node,"__TABLE__");
    final String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");

    final String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");

    List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");

    boolean useFieldOptions = ("true").equals(ElementParameterParser.getValue(node, "__USE_FIELD_OPTIONS__"));

    List<Map<String, String>> fieldOptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_OPTIONS__");

    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_DEBUG_MODE__"));
    final boolean batchMode = ("true").equals(ElementParameterParser.getValue(node, "__BATCH_MODE__"));
    final String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    String db_version = ElementParameterParser.getValue(node, "__DB_VERSION__");
    if(useExistingConnection){
        String connName = ElementParameterParser.getValue(node,"__CONNECTION__");
        INode con_node = NodeUtil.getNodeByUniqueName(node.getProcess(),connName);
        if(con_node!=null){
            db_version = ElementParameterParser.getValue(con_node,"__DB_VERSION__");
        }
    }
    //feature:2880
    Manager manager = getManager(dbmsId, cid, node);
    boolean whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");

    String incomingConnName = null;
    List<IMetadataColumn> columnList = getColumnList(node);

    List< ? extends IConnection> conns = node.getIncomingConnections();
    IConnection inConn = null;
    if(conns!=null && conns.size()>0){
        inConn = conns.get(0);
        incomingConnName = inConn.getName();
    }

    String tempRejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        tempRejectConnName = rejectConn.getName();
    }

    final String rejectConnName = tempRejectConnName;

    boolean useBatch = (rejectConnName == null)
                       && (
                            ("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction) || "COPY".equals(dataAction)
                          )
                       && batchMode;

    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();
    }

    boolean manualCommit = !("0").equals(commitEvery);
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    
        }
    }

    boolean isDynamic = false;
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        isDynamic = metadata.isDynamicSchema();
    }

    List<Column> stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
    isDynamic = isDynamic && !getManager(dbmsId, cid).isDynamicColumnReplaced();

    IMetadataColumn talendDynCol = null;

    ////////////////////////////////////////////////////////////
    List<Column> colStruct =  new ArrayList();
    for(Column colStmt : stmtStructure) {
        if(!colStmt.isReplaced() && !colStmt.isAddCol() && !colStmt.isDynamic()) {
            colStruct.add(colStmt);
        }
    }

    if(isEnableDebug) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
    }

    class DBOutputUtil {

        IConnection connection;
        List<Column> stmtStructure;

        public DBOutputUtil(INode node) {
            List<? extends IConnection> connections = node.getIncomingConnections();
            if(connections!=null && connections.size()>0){
                connection = connections.get(0);
            }
        }

        private String getColumnsSql(List<Column> stmtStructure) {
            return getColumnsSql(stmtStructure,false);
        }

        private String getColumnsSql(List<Column> stmtStructure,boolean ignoreAddedAndReplacementColumn) {
            StringBuilder columnListStr = new StringBuilder();
            boolean firstColumn = true;
            for(Column column : stmtStructure) {
                if(ignoreAddedAndReplacementColumn && column.isAddCol()) {
                    continue;
                }

                if(!ignoreAddedAndReplacementColumn && column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    for(Column replacedColumn : replacedColumns) {
                        if(firstColumn) {
                            firstColumn = false;
                        } else {
                            columnListStr.append(", ");
                        }
                        columnListStr.append(replacedColumn.getName());
                    }
                } else {
                    if(firstColumn) {
                        firstColumn = false;
                    } else {
                        columnListStr.append(", ");
                    }
                    if(column.isDynamic()) {
                        columnListStr.append("\"+");
                        columnListStr.append("DynamicUtils.getInsertIntoStmtColumnsList(");

                        columnListStr.append(connection.getName());
                        columnListStr.append(".");
                        columnListStr.append(column.getName());
                        columnListStr.append(",");
                        columnListStr.append("\"");
                        columnListStr.append(dbmsId);
                        columnListStr.append("\"");

                        columnListStr.append(")");
                        columnListStr.append("+\"");
                    } else {
                        columnListStr.append(column.getName());
                    }
                }
            }
            return columnListStr.toString();
        }

        private void createProjection(boolean createProjection,List<Column> stmtStructure){
            if(createProjection){
                String columnListStr = getColumnsSql(stmtStructure);
            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(columnListStr);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnListStr);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
            }
        }

        public void actionOnTable(INode node,List<Column> stmtStructure){
            this.stmtStructure = stmtStructure;
            boolean createProjection = "true".equals(ElementParameterParser.getValue(node,"__CREATE_PROJECTION__"))&&
                !"true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
                
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
                    createProjection(createProjection,stmtStructure);
                
    stringBuffer.append(TEXT_58);
    
            }else{
                if(!("CLEAR").equals(tableAction) && !("NONE").equals(tableAction)){
                    createProjection(createProjection,stmtStructure);
                }
            }
        }

        public void prepareDataActionMore(INode node,Manager manager,StringBuilder insertColName,StringBuilder insertValueStmt,StringBuilder updateSetStmt,StringBuilder updateWhereStmt){
            if (("COPY").equals(dataAction)) {
                boolean abortOnError = "true".equals(ElementParameterParser.getValue(node,"__ABORT_ON_ERROR__"));
                String rejectMax = ElementParameterParser.getValue(node,"__REJECT_MAX__");
                String exceptionsPath = ElementParameterParser.getValue(node,"__EXCEPTIONS_PATH__");
                String rejectsPath = ElementParameterParser.getValue(node,"__REJECTED_DATA__");
                boolean noCommit = "true".equals(ElementParameterParser.getValue(node,"__NO_COMMIT__"));
                String exceptionNode = ElementParameterParser.getValue(node,"__EXCEPTIONS_NODE__");
                String rejectsNode = ElementParameterParser.getValue(node,"__REJECTED_NODE__");
                rejectMax = rejectMax == null || "".equals(rejectMax.trim()) ? "" : " REJECTMAX "+rejectMax+" ";
                exceptionsPath = exceptionsPath == null || "".equals(exceptionsPath.trim()) ? "" : " EXCEPTIONS '\"+"+exceptionsPath+"+\"' ";
                exceptionNode = exceptionNode == null || "".equals(exceptionNode.trim()) ? "" : " ON "+exceptionNode+" ";
                rejectsPath = rejectsPath == null || "".equals(rejectsPath.trim()) ? "" : " REJECTED DATA '\"+"+rejectsPath+"+\"' ";
                rejectsNode = rejectsNode == null || "".equals(rejectsNode.trim()) ? "" : " ON "+rejectsNode+" ";
                String exceptionString = !"".equals(exceptionsPath) ? exceptionsPath + exceptionNode : "";
                String rejectString = !"".equals(rejectsPath) ? rejectsPath + rejectsNode : "";
                String noComm = !noCommit ? "" : " NO COMMIT ";
                String abort = abortOnError ? " ABORT ON ERROR " : "";
                
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(getColumnsSql(this.stmtStructure,true));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(rejectMax);
    stringBuffer.append(exceptionString);
    stringBuffer.append(rejectString);
    stringBuffer.append(abort);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(noComm);
    stringBuffer.append(TEXT_67);
    
            }
        }

        public void dataActionMore(INode node,List<Column> colStruct,Manager manager,String incomingConnName,List<IMetadataColumn> rejectColumnList,List<IMetadataColumn> columnList){
            if ("COPY".equals(dataAction)) {//don't support additional columns
                int counter = 1;
                for(int i = 0; i < columnList.size(); i++) {
                    IMetadataColumn column = columnList.get(i);
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    if("id_Dynamic".equals(column.getTalendType())) {//dynamic column can't be null
                    
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getPrecision() == null? "currentValue_" + cid : "decimal_" + cid + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getPrecision() == null? "currentValue_" + cid : "decimal_"+cid + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getPrecision() == null? "currentValue_" + cid : "decimal_"+cid + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
                    } else if(JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())){
                    
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
                    }else {
                    
    stringBuffer.append(TEXT_129);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
                            if(javaType == JavaTypesManager.STRING ){
                            
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_137);
    
                            }else if(javaType == JavaTypesManager.DATE && pattern != null){
                            
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_142);
    
                            }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                            
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_146);
    
                            } else if(JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                            
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getPrecision() == null? incomingConnName + "." + column.getLabel() : incomingConnName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_149);
    
                                } else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT) {
                                
    stringBuffer.append(TEXT_150);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(column.getPrecision() == null? incomingConnName + "." + column.getLabel() : "decimal_"+cid+".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_157);
    
                                } else {
                                
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_161);
    
                                }
                            } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                            
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getPrecision() == null? incomingConnName + "." + column.getLabel() : incomingConnName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_164);
    
                            }else{
                            
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_168);
    
                            }
                            
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
                    }
                    counter++;
                    
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append( i == columnList.size() - 1 ? "\\n" : ";");
    stringBuffer.append(TEXT_173);
    
                }
                if(rejectConnName == null) {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
                    if (batchMode) {
                    
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
                    }
                }
            }
        }

    }

    DBOutputUtil dbOutputUtil = new DBOutputUtil(node);

    if(isDynamic) {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
        if(columnList != null && columnList.size()>0) {
            String table = ElementParameterParser.getValue(node,"__TABLE__");

      
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean convertToUppercase_tableAction = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"
	manager = getManager(dbmsId, cid);
	String ending="";
	
	if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
		ending="WITH STRUCTURE = VECTORWISE";
	}
	
	boolean useCascade = "true".equals(ElementParameterParser.getValue(node,"__USE_CASCADE__"));
	
	if(!("NONE").equals(tableAction)) {

        if(("DROP_CREATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_185);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_186);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    dbLog.table().createTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_191);
    	
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					String query=manager.getCreateTableSQL(stmtStructure);
					
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_197);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_198);
    }
    stringBuffer.append(TEXT_199);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_200);
    
				}
			} else {
			
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_203);
    		
			}
			
    stringBuffer.append(TEXT_204);
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    				

        } else if(("CREATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    dbLog.table().createTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_210);
    
			if(isDynamic) {
				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
				if(conns_dynamic!=null && conns_dynamic.size()>0){
					String query=manager.getCreateTableSQL(stmtStructure);
					
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_216);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_217);
    }
    stringBuffer.append(TEXT_218);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_219);
    
				}
			} else {
			
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_222);
    
			}
			
    stringBuffer.append(TEXT_223);
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
        	boolean tableNameCaseSensitive=false;
    		if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
    			tableNameCaseSensitive=true;
    		}
			
    stringBuffer.append(TEXT_226);
    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
			
    stringBuffer.append(TEXT_227);
    //bug22719: informix use independent connection, should remove this code after use shared connection
    		    if(INFORMIX.equalsIgnoreCase(dbmsId)){
    			    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
    	    		String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
    			    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
    				String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
    				String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
    		    	
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_235);
    }else{
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_239);
    }
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    
			}
			
    stringBuffer.append(TEXT_244);
     
    						/*
    						case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
    						so in mssql use "Select" checked the table whether exist.
                			*/
                			//TODO we will use like "select" sql intead of use system table to checked table?
                			if(MSSQL.equalsIgnoreCase(dbmsId)) {
                			
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    
    						} else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {
    						
    stringBuffer.append(TEXT_254);
    stringBuffer.append(manager.generateCode4TabelExist());
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    
                			} else if ( SYBASE.equalsIgnoreCase(dbmsId)
                						|| INFORMIX.equalsIgnoreCase(dbmsId) ) {
                			
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_283);
    }
    stringBuffer.append(TEXT_284);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_287);
    }
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    			
    						} else if( DB2.equalsIgnoreCase(dbmsId) || TERADATA.equalsIgnoreCase(dbmsId)){
    						
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
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
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_307);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_308);
    }
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    
							} else if (GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId) || VERTICA.equalsIgnoreCase(dbmsId)) {
    						
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_343);
    }
    stringBuffer.append(TEXT_344);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_347);
    }
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_353);
    }
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    			
        					} else {
        					
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
    stringBuffer.append(table);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    
    						}
                            
    
                			if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
    						
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    dbLog.table().createTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_375);
    
                        			if(isDynamic) {
                        				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
                        				if(conns_dynamic!=null && conns_dynamic.size()>0){
                        					String query=manager.getCreateTableSQL(stmtStructure);
    										
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_379);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_380);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_381);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_382);
    }
    stringBuffer.append(TEXT_383);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_384);
    
    									}
    								} else {
    								
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_387);
    
    								}
    								
    stringBuffer.append(TEXT_388);
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    
                			} else {
    						
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_397);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_398);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    dbLog.table().createTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_403);
    
                    			if(isDynamic) {
                    				List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
                    				if(conns_dynamic!=null && conns_dynamic.size()>0){
                    					String query=manager.getCreateTableSQL(stmtStructure);
        								
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_407);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_408);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_409);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_410);
    }
    stringBuffer.append(TEXT_411);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_412);
    
        							}
        						} else {
        						
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_415);
    
        						}
        						
    stringBuffer.append(TEXT_416);
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    
        					}
        					
    stringBuffer.append(TEXT_419);
    
			//to fixed: bug8422
			if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
			
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    
			}
            
    stringBuffer.append(TEXT_422);
    
        } else if(("CLEAR").equals(tableAction)) {
		
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    dbLog.table().clearTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_428);
    dbLog.table().clearDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    
        }else if(("TRUNCATE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    dbLog.table().truncateTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_445);
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    }
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_450);
    if(INFORMIX.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_451);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    }
    stringBuffer.append(TEXT_454);
    dbLog.table().truncateDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    
		} else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {
		
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    dbLog.table().truncateReuseStorageTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_467);
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    }
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_472);
    dbLog.table().truncateReuseStorageDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    
		}         
	}
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    
    dbOutputUtil.actionOnTable(node,stmtStructure);
    Map<String, StringBuilder> actionSQLMap = getManager(dbmsId, cid).createProcessSQL(stmtStructure);
    StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
    StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
    StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
    StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
    StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
    talendDynCol = getDynamicColumn();

    if(("INSERT").equals(dataAction)) {
        List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
        if(conns_dynamic!=null && conns_dynamic.size()>0){
            IConnection conn = conns_dynamic.get(0);
            if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_483);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_484);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_485);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_487);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_488);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_489);
              } else {

    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_493);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_494);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_496);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_497);
    
            }
        }
        
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    
    } else if (("UPDATE").equals(dataAction)) {
        List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
        if(conns_dynamic!=null && conns_dynamic.size()>0){
            IConnection conn = conns_dynamic.get(0);
            if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_505);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_506);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_507);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_509);
              } else {

    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_513);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_514);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_516);
    
            }
        }
        
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    
    } else if (("INSERT_OR_UPDATE").equals(dataAction)) {
        List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
        if(conns_dynamic!=null && conns_dynamic.size()>0){
            IConnection conn = conns_dynamic.get(0);
            if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_524);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_525);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_528);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_529);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_530);
              } else {

    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_534);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_536);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_537);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_538);
    
            }
            if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_542);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_543);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_544);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_546);
              } else {

    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_550);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_551);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_552);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_553);
    
            }
        }
        
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    
    } else if (("UPDATE_OR_INSERT").equals(dataAction)) {
        List< ? extends IConnection> conns_dynamic = node.getIncomingConnections();
        if(conns_dynamic!=null && conns_dynamic.size()>0){
            IConnection conn = conns_dynamic.get(0);
            if(!("".equals(insertColName.toString()))) {

    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_568);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_569);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_570);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_572);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_573);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_574);
              } else {

    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_578);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_579);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_581);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_582);
    
            }
            if(!("".equals(updateSetStmt.toString()))) {

    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_586);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_587);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_588);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_590);
              } else {

    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_594);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_595);
    stringBuffer.append(dbmsId );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_597);
    
            }
        }
        
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    
    } else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(deleteWhereStmt.toString());
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    
    }

    dbOutputUtil.prepareDataActionMore(node,manager,insertColName,insertValueStmt,updateSetStmt,updateWhereStmt);

    if(isEnableDebug) {
        
    
	     if(("INSERT").equals(dataAction) || ("INSERT_IGNORE").equals(dataAction)) {

    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    
		} else if (("UPDATE").equals(dataAction)) {

    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    		
		} else if (("INSERT_OR_UPDATE").equals(dataAction) || ("UPDATE_OR_INSERT").equals(dataAction)) {

    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    
		} else if (("DELETE").equals(dataAction)) {

    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    		
		} else if (("REPLACE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    
		} else if (("INSERT_ON_DUPLICATE_KEY_UPDATE").equals(dataAction)) {//mysql

    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    
		}else if (("INSERT_IF_NOT_EXIST").equals(dataAction)) {//MSSQL

    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    
		}

    
    }

}
        
    stringBuffer.append(TEXT_640);
    
    } //end isDynamic

    boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));

    if (isParallelize) { // bug0014422
        String tAsyncIn_cid = "";
        if(conns!=null && conns.size() > 0) {
            tAsyncIn_cid = conns.get(0).getSource().getUniqueName();
        }
        if(!useExistingConnection) {
            if(manualCommit) {

    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_643);
    
            }
        }

        if (useBatch) {

    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(tAsyncIn_cid);
    stringBuffer.append(TEXT_646);
    
        }
    }

    if(incomingConnName != null && columnList != null) {

    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    
        if(("INSERT").equals(dataAction)) {
            int counter = 1;
            for(Column column : colStruct) {
                if(column.isInsertable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());

    stringBuffer.append(TEXT_649);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {

    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_652);
    
                    }
                    counter++;
                }
            }

            if(isDynamic) {
                Column dynamicColumn = getColumn(getDynamicColumn());
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                if(isEnableDebug) {
                
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_656);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    
                }
                if("Dynamic".equals(typeToGenerate)) {
                
    stringBuffer.append(TEXT_659);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_664);
    
                }
            }

            if(isEnableDebug) {

    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    
            }

    
            if(useBatch) {

    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    
                dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));

    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    
            }else {

    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    
                if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_680);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_681);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_683);
    
                        for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_684);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_686);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_688);
    
                        }

    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_696);
    
                    } else {
                    dbLog.logPrintedException("e.getMessage()");

    stringBuffer.append(TEXT_697);
    
                    }
                }

    stringBuffer.append(TEXT_698);
              }

    
        } else if(("UPDATE").equals(dataAction)) {
            int counterCol = 1;
            for(Column column : colStruct) {
                if(column.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_699);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_702);
    
                    }
                    counterCol++;
                }
            }

            if(isDynamic) {
                Column dynamicColumn = getColumn(talendDynCol);
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                if("Dynamic".equals(typeToGenerate)) {
                    if(isEnableDebug) {
                
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_706);
    stringBuffer.append(counterCol);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    
                    }
                
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_715);
    
                }
            }

            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    stringBuffer.append(TEXT_716);
    
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) {
                        if(isDynamic){
                        
    stringBuffer.append(TEXT_717);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
                        }else{
                        
    stringBuffer.append(TEXT_718);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, NORMAL_TYPE));
    
                        }

                        if(isEnableDebug) {
                            if(isDynamic){
                            
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_721);
    
                            }else{
                            
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_724);
    
                            }
                        }
                        counterCol++;
                     }
                     //#############
                    
    stringBuffer.append(TEXT_725);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, NORMAL_TYPE, " + count_"));
    
                    if(isEnableDebug) {
                        if(isDynamic){
                        
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_728);
    
                        }else{
                        
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_731);
    
                        }
                    }
                    counterCol++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    
            }
            
    stringBuffer.append(TEXT_735);
    
            if(useBatch) {
            
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    
                dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
            
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    
            }else {
            
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_748);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_749);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_750);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_751);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_752);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_754);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_756);
    
                        }
                        
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_763);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_764);
    
                    } else {
                        dbLog.logPrintedException("e.getMessage()");
                        
    stringBuffer.append(TEXT_765);
    
                    }
                }
                
    stringBuffer.append(TEXT_766);
    }
    
        } else if (("INSERT_OR_UPDATE").equals(dataAction)) {
            int columnIndex = 1;
            for(Column column : colStruct) {
                if(column.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_767);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    
                        columnIndex++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_768);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, columnIndex, incomingConnName, cid, NORMAL_TYPE));
    
                    columnIndex++;
                }
            }
            
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_776);
    
                int counterCol = 1;
                for(Column column : colStruct) {
                    if(column.isUpdatable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_777);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_780);
    
                        }
                        counterCol++;
                    }
                }

                if(isDynamic) {
                    Column dynamicColumn = getColumn(getDynamicColumn());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                    if("Dynamic".equals(typeToGenerate)) {
                        if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_784);
    stringBuffer.append(counterCol);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_786);
    
                        }
                    
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_790);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(counterCol-1);
    stringBuffer.append(TEXT_792);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_793);
    
                    }
                }

                for(Column column : colStruct) {
                    if(column.isUpdateKey()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        String dbType = column.getColumn().getType();
                        
    
                        //#############for feature:2880
                        if(whereSupportNull && column.getColumn().isNullable()) {
                            if(isDynamic){
                            
    stringBuffer.append(TEXT_794);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                            }else{
                            
    stringBuffer.append(TEXT_795);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, counterCol, incomingConnName, cid, UPDATE_TYPE));
    
                            }

                            if(isEnableDebug) {
                                if(isDynamic){
                                
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_798);
    
                                }else{
                                
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_801);
    
                                }
                            }
                            counterCol++;
                        }
                         //#############
                        
    stringBuffer.append(TEXT_802);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counterCol, incomingConnName, cid, UPDATE_TYPE, " + count_"));
    
                        if(isEnableDebug) {
                            if(isDynamic){
                            
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_804);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_805);
    
                            }else{
                            
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counterCol, "updateSQLSplits_"));
    stringBuffer.append(TEXT_808);
    
                            }
                        }
                        counterCol++;
                    }
                }
                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_811);
    
                }
                
    stringBuffer.append(TEXT_812);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_816);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_818);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_819);
    
                    } else {
                    
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_822);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_823);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_824);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_825);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_827);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_829);
    
                            }
                            
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(TEXT_833);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_834);
    stringBuffer.append(TEXT_835);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_837);
    
                        } else {
                            dbLog.logPrintedException("e.getMessage()");
                            
    stringBuffer.append(TEXT_838);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_839);
    
                int counterInsert = 1;
                for(Column columnInsert : colStruct) {
                    if(columnInsert.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_840);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnInsert, counterInsert, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_841);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_842);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnInsert, incomingConnName, cid, "query_" ,  counterInsert, "insertSQLSplits_"));
    stringBuffer.append(TEXT_843);
    
                        }
                        counterInsert++;
                    }
                }

                if(isDynamic) {
                    Column dynamicColumn = getColumn(getDynamicColumn());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                    if("Dynamic".equals(typeToGenerate)) {
                        if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_844);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_845);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_847);
    stringBuffer.append(counterInsert);
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_849);
    
                        }
                        
    stringBuffer.append(TEXT_850);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(counterInsert-1);
    stringBuffer.append(TEXT_854);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_855);
    
                    }
                }

                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_856);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_858);
    
                }
                
    stringBuffer.append(TEXT_859);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_861);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_862);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_863);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_865);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_866);
    
                    } else {
                    
    stringBuffer.append(TEXT_867);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_868);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_869);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_870);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_871);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_872);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_874);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_876);
    
                            }
                            
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(TEXT_880);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(TEXT_882);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_883);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_884);
    
                        } else {
                            dbLog.logPrintedException("e.getMessage()");
                            
    stringBuffer.append(TEXT_885);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_886);
    
        } else if (("UPDATE_OR_INSERT").equals(dataAction)) {
            
    stringBuffer.append(TEXT_887);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_888);
    
            int counterColUpdate = 1;
            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdatable()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    
    stringBuffer.append(TEXT_889);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_890);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_891);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_892);
    
                    }
                    counterColUpdate++;
                }
            }

            if(isDynamic) {
                Column dynamicColumn = getColumn(getDynamicColumn());
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                if("Dynamic".equals(typeToGenerate)) {
                    if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_894);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_896);
    stringBuffer.append(counterColUpdate);
    stringBuffer.append(TEXT_897);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_898);
    
                    }
                    
    stringBuffer.append(TEXT_899);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_900);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_901);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_902);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_903);
    stringBuffer.append(counterColUpdate-1);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_905);
    
                }
            }

            for(Column columnUpdate : colStruct) {
                if(columnUpdate.isUpdateKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
                    String dbType = columnUpdate.getColumn().getType();
                    
    
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && columnUpdate.getColumn().isNullable()) {
                        if(isDynamic){
                        
    stringBuffer.append(TEXT_906);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(talendDynCol.getLabel(),columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                        }else{
                        
    stringBuffer.append(TEXT_907);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE));
    
                        }

                        if(isEnableDebug) {
                            if(isDynamic){
                            
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_910);
    
                            }else{
                            
    stringBuffer.append(TEXT_911);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_912);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_", "(("+incomingConnName+"."+columnUpdate.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_913);
    
                            }
                        }
                        counterColUpdate++;
                     }
                     //#############
                    
    stringBuffer.append(TEXT_914);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, columnUpdate, counterColUpdate, incomingConnName, cid, UPDATE_TYPE," + count_"));
    
                    if(isEnableDebug) {
                        if(isDynamic){
                        
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(talendDynCol.getLabel(),typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_917);
    
                        }else{
                        
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    stringBuffer.append(getManager(dbmsId, cid, node).retrieveSQL(typeToGenerate, columnUpdate, incomingConnName, cid, "query_" , counterColUpdate, "updateSQLSplits_"));
    stringBuffer.append(TEXT_920);
    
                        }
                    }
                    counterColUpdate++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_921);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_922);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_923);
    
            }
            
    stringBuffer.append(TEXT_924);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_925);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_926);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_928);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_929);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_930);
    
                if(isEnableDebug) {
                
    stringBuffer.append(TEXT_931);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_932);
    
                }
                int counter = 1;
                for(Column column : colStruct) {
                    if(column.isInsertable()) {
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                        
    stringBuffer.append(TEXT_933);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, counter, incomingConnName, cid, INSERT_TYPE));
    
                        if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_934);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_935);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , counter, "insertSQLSplits_"));
    stringBuffer.append(TEXT_936);
    
                        }
                        counter++;
                    }
                }

                if(isDynamic) {
                    Column dynamicColumn = getColumn(talendDynCol);
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(dynamicColumn.getColumn().getTalendType(), dynamicColumn.getColumn().isNullable());
                    if("Dynamic".equals(typeToGenerate)) {
                        if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_937);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_938);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_939);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_940);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_941);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_942);
    
                        }
                        
    stringBuffer.append(TEXT_943);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(dynamicColumn.getName());
    stringBuffer.append(TEXT_945);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_946);
    stringBuffer.append(counter-1);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_948);
    
                    }
                }

                if(isEnableDebug) {
                    
    stringBuffer.append(TEXT_949);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_950);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_951);
    
                }
                
    stringBuffer.append(TEXT_952);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_954);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_955);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_956);
    dbLog.data().inserting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_958);
    dbLog.data().updating(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_960);
    
                    if (("true").equals(dieOnError)) {
                        
    stringBuffer.append(TEXT_961);
    
                    } else {
                    
    stringBuffer.append(TEXT_962);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_963);
    
                        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                            
    stringBuffer.append(TEXT_964);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_965);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_966);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_967);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_969);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_971);
    
                            }
                            
    stringBuffer.append(TEXT_972);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_974);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_976);
    stringBuffer.append(TEXT_977);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_979);
    
                        } else {
                            dbLog.logPrintedException("e.getMessage()");
                            
    stringBuffer.append(TEXT_980);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_981);
    
        } else if (("DELETE").equals(dataAction)) {
            int keyCounter = 1;
            for(Column column : colStruct) {
                if(column.isDeleteKey()) {
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                    String dbType = column.getColumn().getType();
                    
    
                    //#############for feature:2880 and 6980
                    if(whereSupportNull && column.getColumn().isNullable()) { 
    stringBuffer.append(TEXT_982);
    stringBuffer.append(getManager(dbmsId, cid, node).generateSetBooleanForNullableKeyStmt(column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    
                        if(isEnableDebug) {
                            
    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_984);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_", "(("+incomingConnName+"."+column.getName()+"==null)?1:0)"));
    stringBuffer.append(TEXT_985);
    
                            }
                         keyCounter++;
                       }
                     //#############
                    
    stringBuffer.append(TEXT_986);
    stringBuffer.append(getManager(dbmsId, cid).generateSetStmt(typeToGenerate, column, keyCounter, incomingConnName, cid, NORMAL_TYPE));
    
                    if(isEnableDebug) {
                        
    stringBuffer.append(TEXT_987);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(getManager(dbmsId, cid).retrieveSQL(typeToGenerate, column, incomingConnName, cid, "query_" , keyCounter, "deleteSQLSplits_"));
    stringBuffer.append(TEXT_989);
    
                    }
                    keyCounter++;
                }
            }
            if(isEnableDebug) {
                
    stringBuffer.append(TEXT_990);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_991);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_992);
    
            }
            
    
            if(useBatch) {
            
    stringBuffer.append(TEXT_993);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_994);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_995);
    
            dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
            
    stringBuffer.append(TEXT_996);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_997);
    
            }else {
            
    stringBuffer.append(TEXT_998);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_999);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1002);
    dbLog.data().deleting(dbLog.var("nb_line"));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1004);
    
                if (("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1005);
    
                } else {
                
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1007);
    
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1010);
    
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1015);
    
                        }
                        
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1023);
    
                    } else {
                        dbLog.logPrintedException("e.getMessage()");
                        
    stringBuffer.append(TEXT_1024);
    
                    }
                }
                
    stringBuffer.append(TEXT_1025);
    }
    
        }

        dbOutputUtil.dataActionMore(node,colStruct,manager,incomingConnName,rejectColumnList, columnList);
        if("COPY".equals(dataAction) && rejectConnName == null){//TODO why no nb_line++ when rejectConnName == null, if fix on dataActionMore, remove it on this condition
            dbLog.data().addingToBatch(dbLog.var("nb_line"), dbLog.str(dataAction));
        }

        if(outgoingConns != null && outgoingConns.size() > 0) {
            
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1027);
    
                for(IConnection outgoingConn : outgoingConns) {
                    if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                        if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1030);
    
                            for(IMetadataColumn column : columnList) {
                                
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1035);
    
                            }
                        }
                    }
                }
            
    stringBuffer.append(TEXT_1036);
    
        }


        if (useBatch) {
            
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1040);
    
                        if (!"COPY".equals(dataAction)) {
                        
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1042);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    
                        } else {
                        
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1045);
    if("VERTICA_7_0_X".equals(db_version) || "VERTICA_6_1_X".equals(db_version) || "VERTICA_6_0".equals(db_version) || "VERTICA_5_1".equals(db_version)){
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1054);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    }else{
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1058);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    }
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1064);
    
                        }
                        
    
                        if (("INSERT").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1067);
    
                        }else if (("UPDATE").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1070);
    
                        }else if (("DELETE").equals(dataAction)) {
                        
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1073);
    
                        }else if (("COPY").equals(dataAction)) {
                            if("VERTICA_7_0_X".equals(db_version) || "VERTICA_6_1_X".equals(db_version) || "VERTICA_6_0".equals(db_version) || "VERTICA_5_1".equals(db_version)){
                        
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1076);
    
                            }else{
                        
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1079);
    
                            }
                        }
                        
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1081);
    if(("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1082);
    
                    }else {
                    dbLog.logPrintedException("e.getMessage()");
                    
    stringBuffer.append(TEXT_1083);
    
                    }
    stringBuffer.append(TEXT_1084);
    
        }
        ////////////commit every////////////
        if(!useExistingConnection && (!("VERTICA_7_0_X".equals(db_version) || "VERTICA_6_1_X".equals(db_version) || "VERTICA_6_0".equals(db_version) || "VERTICA_5_1".equals(db_version)) || !"COPY".equals(dataAction))) {
            if(manualCommit) {
                
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1088);
    if ((rejectConnName==null && !useExistingConnection) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction)) ||("COPY".equals(dataAction)) ) {
                
    stringBuffer.append(TEXT_1089);
    
                    if (!"COPY".equals(dataAction)) {
                        if (useBatch) {//manual commit and batch mode
                    
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1092);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1094);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1097);
    
                        }
                        if (useBatch){
                    
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1099);
    
                        }
                        if (("INSERT").equals(dataAction)) {
                    
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1102);
    
                        }else if (("UPDATE").equals(dataAction)) {
                    
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1105);
    
                        }else if (("DELETE").equals(dataAction)) {
                    
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1108);
    
                        }
                        if (useBatch){
                    
    stringBuffer.append(TEXT_1109);
    
                        }
                    } else {
                    
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1115);
    dbLog.batch().executeTry(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1119);
    dbLog.batch().executeDone(dbLog.str(dataAction));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1128);
    
                    }
                    
    stringBuffer.append(TEXT_1129);
    if(("true").equals(dieOnError)) {
                    
    stringBuffer.append(TEXT_1130);
    
                    }else {
                        dbLog.logPrintedException("e.getMessage()");
                    
    stringBuffer.append(TEXT_1131);
    
                    }
    stringBuffer.append(TEXT_1132);
    
                }
                
    dbLog.commit().commitTry(null, dbLog.var("commitCounter"));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1134);
    dbLog.commit().commitDone(null);
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1136);
    
            }
        }
    }
    
    stringBuffer.append(TEXT_1137);
    return stringBuffer.toString();
  }
}
