<template>
  <div class="add-car">
    <h1>Agregar un Vehículo</h1>
    <form>
      <div class="InputContainer">
        <input type="marca" v-model="vehicleBrand" placeholder="Ingrese la marca del vehiculo">
        <input type="modelo" v-model="vehicleModel" placeholder="Ingrese el modelo del vehiculo">
        <input type="tipo" v-model="vehicleType" placeholder="Ingrese el tipo de vehiculo">
        <input type="matricula" v-model="vehiculeNumber" placeholder="Ingrese el numero de matricula  del vehiculo">
        <input type="kilometraje" v-model="vehicleMilleage" placeholder="Ingrese el kilometraje del vehiculo">
        <input type="estado" v-model="vehicleState" placeholder="Ingrese el estado del vehiculo">
        <input type="precioBase" v-model="vehicleBasePrice" placeholder="Ingrese el precio base del vehiculo">
        <input type="categoria" v-model="vehicleCategory" placeholder="Ingrese la categoria del vehiculo">
        <input type="transmision" v-model="vehicleTransmission" placeholder="Ingrese el tipo de transmision del vehiculo">
        <input type="combustible" v-model="vehiculeFuel" placeholder="Ingrese el tipo de combustible del vehiculo">
        <input type="idSucursal" v-model="sucursalId" placeholder="Ingrese el numero de Id de la sucursal">
        <button class="sessionButton" @click="agregarVehiculo">Agregar vehiculo</button>
      </div>
      <div class="alsoButtons">
        <router-link to="/menuAdmin">
          <div class="alsoButton" @click="regresar">Regresar al menu anterior</div>
        </router-link>
      </div>
    </form>
  </div>
</template>
  
<script>
  function redireccionarAPaginaAdministrador(){
    window.location.href = '/menuAdmin';
  }
  export default {
    name: 'AddCar',
    data(){
    return{
      brand: '',
      model: '',
      type: '',
      number: '',
      milleage: 0,
      state: '',
      basePrice: 0,
      category: '',
      transmission: '',
      fuel: '',
      photo:'',
      sucursalId: 0,
    }
   },
    methods:{
      regresar(){
        redireccionarAPaginaAdministrador();
      },
      async agregarVehiculo(){
        //Envio de datos a backend
        if (this.vehicleBrand != "" & this.vehicleModel != "" & this.vehicleType != "" & this.vehiculeNumber != "" & this.vehicleMilleage != "" & this.vehicleState != "" & vehicleBasePrice != "" & vehicleCategory != "" & vehicleTransmission != "" & this.vehiculeFuel != "" & this.sucursalId != "") {
          const nuevo_vehiculo = {
            "marca": this.vehicleBrand,
            "modelo": this.vehicleModel,
            "tipo": this.vehicleType,
            "matricula": this.vehicleNumber,
            "kilometraje": this.vehicleMilleage,
            "estado": this.vehicleState,
            "preciobase": this.vehicleBasePrice,
            "categoria": this.vehicleCategory,
            "transmision": this.vehicleTransmission,
            "combustible": this.vehiculeFuel,
            "fotovehiculo": 0,
            "sucursal": this.sucursalId,
          }
          try {
            const registro = await axios.post(import.meta.env.VITE_BASE_URL + "api/vehiculo/crearVehiculo", nuevo_vehiculo);
            console.log(registro)
            alert("Vehiculo agregado con exito")
          } catch (error) {
            alert("No se pudo agregar con esos valores")
          }
        } else {
          alert("Faltan datos para ingresar")
        }
      }
    },
  }
</script>
