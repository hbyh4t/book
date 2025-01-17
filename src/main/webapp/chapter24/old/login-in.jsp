<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../chapter25/menu.jsp" %>
<!-- CDNを使ってValidator.jsを追加 -->
<script src="https://cdn.jsdelivr.net/npm/validator@13.7.0/validator.min.js"></script>
<form id="validationForm" action="Login.action" method="post">
<p>ログイン名<input id="loginInput" type="text" name="login"></p>
<p>パスワード<input id="passwordInput" type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<script>
      document
        .getElementById("validationForm")
        .addEventListener("submit", function (event) {
          // 入力値を取得
          const login = document.getElementById("loginInput").value;
          const password = document.getElementById("passwordInput").value;
          // 初期化
          let isValid = true;

          // 文字数の検証（5～10文字）
          if (!validator.isLength(login, { min: 1, max: 20 })) {
              alert('ログイン名を入力してください');
            isValid = false;
          }
          
          // 文字数の検証（5～10文字）
          if (!validator.isLength(password, { min: 1, max: 20 })) {
              alert('パスワードを入力してください');
            isValid = false;
          }

          // 検証結果に応じて処理を分岐
          if (isValid) {
            // フォームを送信する
            // `this` はフォーム要素を指す
            this.submit();
          } else {
            // 検証に失敗した場合、フォームの送信を防ぐ
            event.preventDefault();
          }
        });
    </script>

<%@include file="../footer.html" %>
