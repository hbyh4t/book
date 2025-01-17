<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.jsp"%>
<%@include file="../chapter25/menu.jsp"%>
<style>
    /* ログアウトリンクのスタイル */
	.logout-link {
        background-color: #32d765;
	}
</style>
<div class="wrapper">
	<div class="message-container">
		<div class="message-box">
			<p>ログアウトしますか？</p>
			<p>
				<a href="Logout.action">ログアウト</a>
			</p>
		</div>
	</div>
</div>
<%@include file="../footer.jsp"%>
