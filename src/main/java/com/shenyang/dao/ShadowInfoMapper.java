package com.shenyang.dao;

import com.shenyang.bean.ShadowInfo;
import com.shenyang.bean.ShadowInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShadowInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    long countByExample(ShadowInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    int deleteByExample(ShadowInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    int insert(ShadowInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    int insertSelective(ShadowInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    List<ShadowInfo> selectByExample(ShadowInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    ShadowInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    int updateByExampleSelective(@Param("record") ShadowInfo record, @Param("example") ShadowInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    int updateByExample(@Param("record") ShadowInfo record, @Param("example") ShadowInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    int updateByPrimaryKeySelective(ShadowInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHADOWINFO
     *
     * @mbg.generated Sat Oct 07 12:07:57 CST 2017
     */
    int updateByPrimaryKey(ShadowInfo record);
}