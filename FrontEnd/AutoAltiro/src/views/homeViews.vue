<script setup>
  import styles from '@/components/styles.vue';

</script>

<template>
    <main>
        <div class="general">
            <div class="content">
                <img class="image" src="./media/LogoUsachNegro.png">
                <div class="header">Inicio de sesion</div>
                <div class="headerDescription" v-if="!register">Completar campos para iniciar sesion</div>
                <div class="headerDescription" v-else>Completar campos para registro</div>
                <div class="inputContainers" v-if="!register">
                    <input type="email" v-model="username" placeholder="Ingrese correo">
                    <input type="password" v-model="password" placeholder="Ingrese contraseña">
                    <button class="sessionButton" @click="login">Iniciar Sesion</button>
                </div>
                <div class="InputContainer" v-else>
                    <input type="email" v-model="usernameRegister" placeholder="Ingrese correo">
                    <input type="password" v-model="passwordRegister" placeholder="Ingrese contraseña">
                    <input type="password" v-model="passwordRegisterConfirmation" placeholder="Ingrese contraseña nuevamente">
                    <input type="rut" v-model="rutRegister" placeholder="Ingrese rut">
                    <input type="name" v-model="nameRegister" placeholder="Ingrese su nombre">
                    <input type="age" v-model="ageRegister" placeholder="Ingrese su edad">
                    <input type="documentName" v-model="documentNameRegister" placeholder="Ingrese su numero de documento">
                    <input type="licenceNumber" v-model="licenceNumberRegister" placeholder="Ingrese su numero de licencia de conducir">
                    <button class="sessionButton" @click="addUser">Registrarse</button>
                </div>
                <div class="alsoButtons">
                    <div class="alsoButton" @click="handleChange" v-if="!register">Registrarse</div>
                    <div class="alsoButton" @click="handleChange" v-else>Iniciar Sesion</div>
                    <router-link to="/anonimo">
                        <div class="alsoButton" @click="handleChange">Ingresar sin iniciar sesion</div>
                    </router-link>
                </div>
            </div>
        </div>
    </main>
</template>


<script>

import axios from 'axios'

//Redireccionamiento
//Usuario
function redireccionarASubpaginaSeleccionTipoUsuario(){
    //CAMBIAR POR /tipoUsuario cuando se pueda
    window.location.href = '/menuPrincipalAdmin';

}
//Usuario Anonimo
function redireccionarASubpaginaUsuarioAnonimo(){
    window.location.href = '/consultaFlota';
    
}

export default{
    data (){
        return{
            username: '',
            password: '',
            loggedIn: false,
            register: false,
            usernameRegister: '',
            passwordRegister: '',
            passwordRegisterConfirmation: '',
            rutRegister: '',
            nameRegister:'',
            ageRegister:'',
            documentNameRegister:'',
            licenceNumberRegister:'',

        }
    },
    methods:{
        async login(){
            //Envio de datos a backend
            const usuario = {
                "email": this.username,
                "password": this.password,
                
            };
            try {
                const respuesta = await axios.post(import.meta.env.VITE_BASE_URL + "api/usuario/login", usuario);
                if (respuesta.data == 1){
                    localStorage.setItem('login', JSON.stringify(this.username));
                    redireccionarASubpaginaSeleccionTipoUsuario();
                }
                if(respuesta.data == 0){
                    alert("Credenciales Invalidas");
                }
                respuesta.data = 0;
                console.log(respuesta.data);

            } catch (error) {
                alert("No se genera conexion con el servidor")
            }
        },
        handleChange(){
            this.register = !this.register
            console.log(this.register)
        },
        anonimo(){
            this.username = "anonimo"
            redireccionarASubpaginaUsuarioAnonimo();
            localStorage.setItem("login", JSON.stringify(this.username));
        },
        async addUser(){
            //Envio de datos a BackEnd
            if(this.passwordRegister == this.passwordRegisterConfirmation){
                if(this.usernameRegister != "" & this.passwordRegister != "" & this.rutRegister != "" & this.nameRegister != "" & this.ageRegister != "" & this.documentNameRegister != "" & this.licenceNumberRegister != ""){
                    const nuevo_usuario = {
                        "email": this.usernameRegister,
                        "password": this.passwordRegister,
                        "rut": this.rutRegister,
                        "name": this.nameRegister,
                        "age": this.ageRegister,
                        "documentName": this.documentNameRegister,
                        "licenseNumber": this.licenceNumberRegister,
                    }
                    try {
                        const registro = await axios.post(import.meta.env.VITE_BASE_URL + "api/usuario/register", nuevo_usuario);
                        console.log(registro)
                        alert("Usuario registrado con exito")
                    } catch (error) {
                        alert("No se pudo registrar")
                    }
                }
                else{
                    alert("Faltan datos para ingresar")
                }
            }
            else{
                alert("Las contraseñas deben coincidir")
            }
        }
    }
}
</script>

<style>
.general {
    background-image: url("./media/wolvmeme.jpg");

    height: 100vh;
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center;

    display: flex;
    justify-content: center;
    align-items: center;
    align-content: center;
    
}

.image{
    height: 150px;
}

.content{
    box-sizing: border-box;
    padding: 10px;
    background-color: #f8f6f6f3;
    display: flex;
    flex-direction: column;
    align-items: center;

    min-width: 300px;
    max-width: 500px;
    width: 100%;
    margin: 0px 10px 0px 10px;
    min-height: 500px;
    max-height: 550px;
    height: 100%;

    border-radius: 10px;
}

.header {
    text-align: center;
    line-height: 1;
    font-size: 40px;
    font-weight: 500 !important;
    color: black;
}

.headerDescription{
    font-size: 16px;
    margin-bottom: 20px;
    color: black;
}

.inputContainers {
    display: flex;
    gap: 1px;
    width: 100%;
    max-width: 400px;
    flex-direction: column;
}

input{
    height: 50px;
    box-sizing: border-box;

    padding: 10px !important;
    font-size: 16px;
    border-radius: 4px;
    outline: none;
    border: #cdcdcd solid 3px;
    transition: border 0.2s;
}

input:hover{
    border: #bbbbbb solid 3px;
    transition: border 0.2s;
}

input:focus{
    border: #888888 solid 3px;
    transition: border 0.2s;
}

.sessionButton{
    height: 50px;
    background-color: #1769aa;
    color: #f5f5f5;
    font-size: 16px;
    font-weight: 500;
    border: #1769aa solid 2px;
    border-radius: 3px;
    cursor: pointer;
    transition: background-color 0.2s;
    margin-bottom: 10px;
}

.sessionButton:hover{
    background-color: #1f81d1;
    transition: background-color 0.2s;
}

.alsoButton{
    cursor: pointer;
    font-weight: 500;
    transition: all 0.2s;
    color: black;
}

.alsoButton:hover{
    text-decoration: underline;
    transition: all 0.2s;
}

@media (min-width: 418px){
    .content{
        max-height: 500px;
    }
}

</style>


