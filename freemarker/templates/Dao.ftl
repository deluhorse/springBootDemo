package ${package_name}.${table_name};
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
@Mapper
public interface ${table_name}Dao {
    @SelectProvider(type = ${table_name}SqlBuilder.class, method = "insert")
    void insert(${table_name} ${table_name?uncap_first});
}