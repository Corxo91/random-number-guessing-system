package santana.marcos.mapper;

import santana.marcos.entity.RandomNumber;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RandomNumberMapper {
    @Select("SELECT * FROM random_number LIMIT 1")
    RandomNumber getRandomNumber();

    @Insert("INSERT INTO random_number(number) VALUES(#{number})")
    void insertRandomNumber(@Param("number") int number);

    @Delete("DELETE FROM random_number")
    void deleteAll();
}