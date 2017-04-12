<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
  var contextPath = "${ctx}";
</script>
<div class="soubg">
  <div class="sou">
    <!--Begin 所在收货地区 Begin-->
    <span>
		<a href="" target="_top" class="h">亲，请登录</a>&nbsp;&nbsp;&nbsp;
		<a href="" target="_top">免费注册</a>&nbsp;&nbsp;&nbsp;
	</span>
	<span>
		<a href="" target="_top" >手机逛淘宝</a>
	</span>
    	
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
          <c:if test="${sessionScope.loginUser==null}">
            <span class="fl">你好，请<a href="${ctx}/Login?action=toLogin"  style="color:#ff4e00;">登录</a>&nbsp;<a href="${ctx}/Register?action=toRegister" style="color:#ff4e00;">免费注册</a>&nbsp;&nbsp;</span>
          </c:if>
          <c:if test="${sessionScope.loginUser!=null}">
            <span class="fl"><a href="${ctx}/admin/user?action=index">${sessionScope.loginUser.userName}</a>&nbsp;|&nbsp;<a href="${ctx}/admin/order?action=index&userId=${sessionScope.loginUser.id}">我的订单</a>&nbsp;</span>
          </c:if>
           <c:if test="${sessionScope.loginUser!=null && sessionScope.loginUser.type==1}">
            <span class="fl">|&nbsp;<a href="${ctx}/admin/product?action=index&userId=${sessionScope.loginUser.id}">后台管理</a>&nbsp;</span>
          </c:if>
           <c:if test="${sessionScope.loginUser!=null}">
             <span class="fl">|&nbsp;<a href="${ctx}/Login?action=loginOut" >注销</a></span>
          </c:if>
        </span>
  </div>
</div>
<div id="fade1" class="black_overlay"></div>
<div id="MyDiv1" class="white_content">
  <div class="white_d">
    <div class="notice_t">
      <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="${ctx}/statics/images/close.gif" /></span>
    </div>
    <div class="notice_c">
      <table border="0" align="center" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td width="40"><img src="${ctx}/statics/images/suc.png"></td>
          <td>
            <span style="color:#3e3e3e; font-size:18px; font-weight:bold;" id="showMessage">操作成功</span><br />
          </td>
        </tr>
      </table>
    </div>
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

