<div id="loginjsp">
  <div class="flex place-content-center">
    <!-- Login Form -->
    <div id="login-form"
      class="flex h-screen justify-center items-center mt-[-20px]">
      <form>
        <h1
          class="text-8xl font-bold bg-gradient-to-r from-red-500 to-red-200 bg-clip-text text-transparent mb-4">LOGIN</h1>
        <fieldset
          class="border-2 border-gray-300 p-4 px-12 py-6 rounded-lg">
          <table class="m-5">
            <tr>
              <td class="pr-5"><label for="login-username">Username</label></td>
              <td><input type="text" id="username"
                name="login-username" required placeholder="Username"
                class="w-full border rounded py-2 pr-20 pl-3 my-2 text-xl" /></td>
            </tr>
            <tr>
              <td><label for="login-password">Password</label></td>
              <td><input type="password" id="login-password"
                name="login-password" required placeholder="Password"
                class="w-full border rounded py-2 pr-20 pl-3 my-2 text-xl" /></td>
            </tr>
          </table>
          <div class="mt-4 pt-5">
            <div class="flex justify-center space-x-6">
              <button type="reset" id="login-clear"
                class="bg-gray-300 text-gray-700 px-10 py-2 rounded">Clear</button>
              <button type="button" id="btnLogin"
                class="bg-red-500 text-white px-10 py-2 rounded">Login</button>
            </div>
            <div class="text-center mt-4">
              <a href="#" id="show-forgot"
                class="text-blue-500 hover:underline">Forgot
                Password?</a>
            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>
<jsp:include page="nav/footer.jsp"></jsp:include>

<script src="js/login.js"></script>
<script src="js/anim.js"></script>
