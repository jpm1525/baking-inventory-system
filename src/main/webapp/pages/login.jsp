<div id="loginjsp">
<div class="flex items-center justify-center min-h-screen p-4">
<div class="w-[60%] max-w-[610px] p-4 bg-transparent rounded-lg shadow-md mb-20">
        <!-- Login Form -->
        <div id="login-form">
            <h1 class="text-7xl font-bold bg-gradient-to-r from-red-500 to-red-200 bg-clip-text text-transparent mb-4">LOGIN</h1>
            <form>
                <fieldset class="border-2 border-gray-300 p-4 px-12 py-6 rounded-lg">
                    <table>
                        <tr>
                            <td class="pl-9"><label for="login-username">Username</label></td>
                            <td class="pl-7"><input type="text" id="username" name="login-username" required placeholder="Username" class="w-full border rounded py-2 pr-20 pl-3 my-1"/></td>
                        </tr>
                        <tr >
                            <td class="pl-9"><label for="login-password">Password</label></td>
                            <td class="pl-7"><input type="password" id="login-password" name="login-password" required placeholder="Password" class="w-full border rounded py-2 pr-20 pl-3 my-1"/></td>
                        </tr>
                    </table>
                    <div class="mt-4 pt-5">
                        <div class="flex justify-center space-x-6">
                            <button type="button" id="btnLogin" class="bg-red-500 text-white px-10 py-2 rounded">Login</button>
                            <button type="reset" id="login-clear" class="bg-gray-300 text-gray-700 px-10 py-2 rounded">Clear</button>
                        </div>
                        <div class="text-center mt-4">
                            <h4 class="text-white">Register <a href="#" id="show-register" class="text-blue-500 hover:underline">Here</a></h4>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>

       <!-- Registration Form -->
<div id="register-fields" class="hidden">
    <h1 class="text-7xl font-bold bg-gradient-to-r from-blue-500 to-blue-200 bg-clip-text text-transparent mb-4">REGISTER</h1>
    <form>
        <fieldset class="border-2 border-gray-300 p-4 py-6 rounded-lg">
            <table>
                <tr>
                    <td class="pl-9"><label for="firstname">First Name</label></td>
                    <td class="pl-8"><input type="text" id="firstname" name="firstname" required placeholder="First Name" class="w-full border rounded py-2 pr-20 pl-3 my-1"/></td>
                </tr>
                <tr>
                    <td class="pl-9"><label for="lastname">Last Name</label></td>
                    <td class="pl-8"><input type="text" id="lastname" name="lastname" placeholder="Last Name" class="w-full border rounded py-2 pr-20 pl-3 my-1"/></td>
                </tr>
                <tr>
                    <td class="pl-9"><label>Gender</label></td>
                    <td class="pl-8">
                        <label class="mr-4"><input type="radio" name="gender" value="male" class="m-4"/> Male</label>
                        <label><input type="radio" name="gender" value="female" class="m-4"/> Female</label>
                    </td>
                </tr>
                <tr>
                    <td class="pl-9 pr-4"><label for="status">Civil Status</label></td>
                    <td class="pl-8">
                        <select id="status" name="status" class="w-full border rounded p-2">
                            <option value="s">Single</option>
                            <option value="m">Married</option>
                            <option value="w">Widowed</option>
                            <option value="a">Annulled</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="pl-9"><label for="address">Address</label></td>
                    <td class="pl-8"><textarea id="address" rows="2" name="address" placeholder="Address" class="w-full border rounded py-2 pr-20 pl-3 mt-2"></textarea></td>
                </tr>
                <tr>
                    <td class="pl-9"><label for="username">Username</label></td>
                    <td class="pl-8"><input type="text" id="username" name="username" required placeholder="Username" class="w-full border rounded py-2 pr-20 pl-3 my-1"/></td>
                </tr>
                <tr>
                    <td class="pl-9"><label for="password">Password</label></td>
                    <td class="pl-8"><input type="password" id="password" name="password" required placeholder="Password" class="w-full border rounded py-2 pr-20 pl-3 my-1"/></td>
                </tr>
                <tr>
                    <td class="pl-9"><label for="confirm-password">Confirm Password</label></td>
                    <td class="pl-8"><input type="password" id="confirm-password" name="confirm-password" required placeholder="Confirm Password" class="w-full border rounded py-2 pr-20 pl-3 my-1"/></td>
                </tr>
                <tr>
                    <td class="pl-9 pr-4"><label for="email">Email</label></td>
                    <td class="pl-8"><input type="email" id="email" name="email" required placeholder="Email" class="w-full border rounded py-2 pr-20 pl-3 my-1"/></td>
                </tr>
            </table>
            <div class="mt-4">
                <div class="flex justify-center space-x-6">
                    <button type="submit" id="btnSub" class="bg-blue-500 text-white px-10 py-2 rounded">Register</button>
                    <button type="reset" id="btnClr" class="bg-gray-300 text-gray-700 px-10 py-2 rounded">Clear</button>
                </div>
                <div class="text-center mt-4">
                    <h4 class="text-white ">Already have an account? Log In <a href="#" id="show-login" class="text-red-500 hover:underline">Here</a></h4>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</div>
</div>
</div>

<script src="js/login.js"></script>
<script src="js/anim.js"></script>
