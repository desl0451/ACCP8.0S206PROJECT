<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="soubg">
 	<div class="sou">
    	<!--Begin 所在收货地区 Begin-->
    	<span class="s_city_b">
        	<span class="fl">中国</span>
            <span class="s_city">
            	<span>大陆</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!-- 上左边栏 -->
        <span>
        	<span class="fl">
        		<a href="Login.jsp"  style="color:#ff4e00;cursor:hand;">亲,请登录</a>&nbsp; 
        		<a href="Regist.jsp">免费注册</a>&nbsp;&nbsp;
        		<a href="#">手机逛淘宝</a>&nbsp;</span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
        	
        	<span class="ss">
        		<div class="ss_list">
                	<a href="#">我的淘宝</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">已买到的宝贝</a></li>
                                <li><a href="#">我的足迹</a></li>
                            </ul>
                        </div>
                    </div>     
                </div>
        		<div class="ss_list">
                	<a href="#">购物车</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">已买到的宝贝</a></li>
                                <li><a href="#">我的足迹</a></li>
                            </ul>
                        </div>
                    </div>     
                </div>
            	<div class="ss_list">
                	<a href="#">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">我的收藏夹</a></li>
                                <li><a href="#">我的收藏夹</a></li>
                            </ul>
                        </div>
                    </div>     
                </div>
                <div class="ss_list">
                	<a href="#">商品分类</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
                <span class="fl">&nbsp;|&nbsp;</span>
                 <div class="ss_list">
                	<a href="#">卖家中心</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t">免费开店</div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">已卖出的宝贝</a></li>
                                <li><a href="#">出售中的宝贝</a></li>
                                <li><a href="#">卖家服务市场</a></li>
                                <li><a href="#">卖家培训中心</a></li>  
                            </ul>
                        </div>
                    </div>    
                </div>
                <div class="ss_list">
                	<a href="#">联系客服</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">消费者服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">消费者服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
            </span>
          <!--   <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span> -->
        </span>
    </div>
</div>

<link type="text/css" rel="stylesheet" href="${ctx}/statics/css/style.css"/>
<script type="text/javascript" src="${ctx}/statics/js/common/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/menu.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/select.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/lrscroll.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/iban.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/fban.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/f_ban.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/mban.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/bban.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/hban.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/tban.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/lrscroll_1.js"></script>

<script type="text/javascript" src="${ctx}/statics/js/register/register.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/ShopShow.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/MagicZoom.css" />
<script type="text/javascript" src="${ctx}/statics/js/common/MagicZoom.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/num.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/p_tab.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common/shade.js"></script>

