<div id="register-fields"
  class="hidden flex flex-col items-center w-full max-w-md p-4 bg-white rounded-lg shadow-md">
  <h5
    class="text-4xl font-bold bg-gradient-to-r from-blue-500 to-blue-200 bg-clip-text text-transparent mb-4">REGISTER</h5>
  <form>
    <table class="w-full">
      <tr>
        <td class="pr-4"><label for="firstname"
          class="block text-gray-700">First Name</label></td>
        <td><input type="text" id="firstname" name="firstname"
          required placeholder="First Name"
          class="w-full border rounded p-2" /></td>
      </tr>
      <tr>
        <td class="pr-4"><label for="lastname"
          class="block text-gray-700">Last Name</label></td>
        <td><input type="text" id="lastname" name="lastname"
          placeholder="Last Name" class="w-full border rounded p-2" /></td>
      </tr>
      <tr>
        <td class="pr-4"><label class="block text-gray-700">Gender</label></td>
        <td><label class="mr-4"><input type="radio"
            name="gender" value="male" class="mr-1" /> Male</label> <label><input
            type="radio" name="gender" value="female" class="mr-1" />
            Female</label></td>
      </tr>
      <tr>
        <td class="pr-4"><label for="status"
          class="block text-gray-700">Civil Status</label></td>
        <td><select id="status" name="status"
          class="w-full border rounded p-2">
            <option value="s">Single</option>
            <option value="m">Married</option>
            <option value="w">Widowed</option>
            <option value="a">Annulled</option>
        </select></td>
      </tr>
      <tr>
        <td class="pr-4"><label for="address"
          class="block text-gray-700">Address</label></td>
        <td><textarea id="address" rows="2" name="address"
            placeholder="Address" class="w-full border rounded p-2"></textarea></td>
      </tr>
      <tr>
        <td class="pr-4"><label for="username"
          class="block text-gray-700">Username</label></td>
        <td><input type="text" id="username" name="username"
          required placeholder="Username"
          class="w-full border rounded p-2" /></td>
      </tr>
      <tr>
        <td class="pr-4"><label for="password"
          class="block text-gray-700">Password</label></td>
        <td><input type="password" id="password" name="password"
          required placeholder="Password"
          class="w-full border rounded p-2" /></td>
      </tr>
      <tr>
        <td class="pr-4"><label for="confirm-password"
          class="block text-gray-700">Confirm Password</label></td>
        <td><input type="password" id="confirm-password"
          name="confirm-password" required
          placeholder="Confirm Password"
          class="w-full border rounded p-2" /></td>
      </tr>
      <tr>
        <td class="pr-4"><label for="email"
          class="block text-gray-700">Email</label></td>
        <td><input type="email" id="email" name="email" required
          placeholder="Email" class="w-full border rounded p-2" /></td>
      </tr>
    </table>
    <div class="mt-4">
      <div class="flex justify-between">
        <button type="submit" id="btnSub"
          class="bg-blue-500 text-white px-4 py-2 rounded">Register</button>
        <button type="reset" id="btnClr"
          class="bg-gray-300 text-gray-700 px-4 py-2 rounded">Clear</button>
      </div>
      <div class="text-center mt-4">
        <h4 class="text-gray-700">
          Already have an account? Log In <a href="#" id="login-link"
            class="text-blue-500 hover:underline">Here</a>
        </h4>
      </div>
    </div>
  </form>
</div>
