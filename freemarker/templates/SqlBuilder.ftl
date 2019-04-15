package ${package_name}.${table_name};
import com.delu.springboot.autochess.tools.SqlUtils;
import org.apache.ibatis.jdbc.SQL;
/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
public class ${table_name}SqlBuilder {
    public static String insert(${table_name} ${table_name?uncap_first}){

        return new SQL(){{

            INSERT_INTO("tbl_ch_chess");
            INTO_COLUMNS(
            <#if model_column?exists>
                <#list model_column as model>
                    <#if model.columnType != 'timestamp' >
                    "${model.columnName}",
                    </#if>
                </#list>
            </#if>
            );
            INTO_VALUES(
                    <#if model_column?exists>
                        <#list model_column as model>
                            <#if model.columnType != 'timestamp' >
                            SqlUtils.formatField(${table_name?uncap_first}.get${model.changeColumnName}()),
                            </#if>
                        </#list>
                    </#if>
            );
        }}.toString();
    }
}