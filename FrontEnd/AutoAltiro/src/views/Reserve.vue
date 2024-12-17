<template>
    <div class="reserve">
      <h1>Reservar un Vehículo</h1>
      <form>
        <label for="license">Placa del vehículo:</label>
        <input id="license" type="text" placeholder="Ingrese la placa del vehículo" />
  
        <label for="date">Fecha de reserva incial:</label>
        <input id="date" type="date" />

        <label for="date">Fecha de reserva final:</label>
        <input id="date" type="date" />
  
        <button type="submit">Reservar</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Reserve',
  };
  </script>
  