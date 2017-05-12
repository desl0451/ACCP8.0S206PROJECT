<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	var contextPath = "${ctx}";
</script>
<div class="site-nav">
	<div class="top">
		<!--Begin 登陆 Begin-->
		<span class="site-nav-bd-l"> <a href="" target="_top" class="h">亲，请登录</a>
			<a href="" target="_top">免费注册</a> &nbsp;&nbsp;&nbsp; <a href=""
			target="_top" class="site-nav-mobile">手机逛淘宝</a>
		</span> <span class="site-nav-bd-r">
			<ul>
				<li>我的淘宝</li>
				<li>购物车</li>
				<li>收藏夹</li>
				<li>商品分类|</li>
				<li>卖家中心</li>
				<li>联系客服</li>
				<li>网站导航</li>
			</ul>
		</span>
	</div>
	<div class="site-nav-top-wrap">
		<div class="logo">
			<img alt="" src="${ctx}/statics/images/index/logo.png">
		</div>
		<div class="search-bd">
			<div id="J_SearchTab" class="search-triggers">
				<ul class="ks-switchable-nav">
					<li class="selected">宝贝</li>
					<li class="tmall-search-tab">天猫</li>
					<li class="shop-search-tab">店铺</li>
				</ul>
				<div class="search-tab-icon">
					<i><em></em><span></span></i>
				</div>
			</div>
			<div class="search">
				<form>
					<input type="text" value="" class="s_ipt" /> <input type="submit"
						value="搜索" class="s_btn" />
				</form>
				<span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a
					href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
			</div>
			<div class="i_car">
				<div class="car_t">
					购物车 [ <span>3</span> ]
				</div>
				<div class="car_bg">
					<!--Begin 购物车未登录 Begin-->
					<div class="un_login">
						还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a> 查看购物车！
					</div>
					<!--End 购物车未登录 End-->
					<!--Begin 购物车已登录 Begin-->
					<ul class="cars">
						<li>
							<div class="img">
								<a href="#"><img src="images/car1.jpg" width="58"
									height="58" /></a>
							</div>
							<div class="name">
								<a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a>
							</div>
							<div class="price">
								<font color="#ff4e00">￥399</font> X1
							</div>
						</li>
						<li>
							<div class="img">
								<a href="#"><img src="images/car2.jpg" width="58"
									height="58" /></a>
							</div>
							<div class="name">
								<a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a>
							</div>
							<div class="price">
								<font color="#ff4e00">￥399</font> X1
							</div>
						</li>
						<li>
							<div class="img">
								<a href="#"><img src="images/car2.jpg" width="58"
									height="58" /></a>
							</div>
							<div class="name">
								<a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a>
							</div>
							<div class="price">
								<font color="#ff4e00">￥399</font> X1
							</div>
						</li>
					</ul>
					<div class="price_sum">
						共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span>
					</div>
					<div class="price_a">
						<a href="#">去购物车结算</a>
					</div>
					<!--End 购物车已登录 End-->
				</div>
			</div>
		</div>
	</div>
</div>
