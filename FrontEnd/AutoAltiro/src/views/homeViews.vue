<template>
    <AppLayout title="Inicio">
      <div class="general">
        <div class="content">
          <img class="image" src="./media/LogoUsachNegro.png">
          <div class="header">Inicio de sesión</div>
          <div class="headerDescription" v-if="!register">Completar campos para iniciar sesión</div>
          <div class="headerDescription" v-else>Completar campos para registro</div>
  
          <div class="inputContainers" v-if="!register">
            <input type="email" v-model="username" placeholder="Ingrese correo">
            <input type="password" v-model="password" placeholder="Ingrese contraseña">
            <button class="sessionButton" @click="login">Iniciar Sesión</button>
          </div>
  
          <div class="inputContainers" v-else>
            <input type="email" v-model="usernameRegister" placeholder="Ingrese correo">
            <input type="password" v-model="passwordRegister" placeholder="Ingrese contraseña">
            <input type="password" v-model="passwordRegisterConfirmation" placeholder="Ingrese contraseña nuevamente">
            <button class="sessionButton" @click="addUser">Registrarse</button>
          </div>
  
          <div class="alsoButtons">
            <div class="alsoButton" @click="handleChange" v-if="!register">Registrarse</div>
            <div class="alsoButton" @click="handleChange" v-else>Iniciar Sesión</div>
            <router-link to="/anonimo">
              <div class="alsoButton">Ingresar sin iniciar sesión</div>
            </router-link>
          </div>
        </div>
      </div>
    </AppLayout>
  </template>
