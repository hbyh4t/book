<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <title>ログイン画面</title>
  </head>
  <body>
    <h1>ログイン</h1>
    <form action="login" method="post">
      <label for="username">ユーザー名：</label>
      <input type="text" name="username" id="username" required /><br />
      <label for="password">パスワード：</label>
      <input type="password" name="password" id="password" required /><br />
      <button type="submit">ログイン</button>
    </form>
  </body>
</html>
