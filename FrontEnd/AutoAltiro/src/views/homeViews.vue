<script setup>


</script>

<template>
    <main>
        <div class="general">
            <div class="content">
                <img src="">
                <div class="header">Inicio de sesion</div>
                <div class="headerDescription" v-if="!register">Completar campos para iniciar sesion</div>
                <div class="headerDescription" v-else>Completar campos para registro</div>
                <div class="InputContainer" v-if="!register">
                    <input type="email" v-model="username" placeholder="Ingrese correo">
                    <input type="password" v-model="password" placeholder="Ingrese contraseña">
                    <button class="sessionButton" @click="login">Inciar Sesion</button>
                </div>
                <div class="InputContainer" v-else>
                    <input type="email" v-model="usernameRegister" placeholder="Ingrese correo">
                    <input type="password" v-model="passwordRegister" placeholder="Ingrese contraseña">
                    <input type="password" v-model="passwordRegisterConfirmation" placeholder="Ingrese contraseña nuevamente">
                    <button class="sessionButton" @click="addUser">Registrarse</button>
                </div>
                <div class="alsoButtons">
                    <div class="alsoButton" @click="handleChange" v-if="!register">Regisgtrarse</div>
                    <div class="alsoButton" @click="handleChange" v-else>Iniciar Sesion</div>
                    <router-link to="/anonimo">
                        <div class="alsoButton" @click="handleChange">Ingresar sin iniciar sesion</div>
                    </router-link>

                </div>
            </div>
        </div>
    </main>

</template>

<style>


</style>