package org.example;

public class TarjetaMetro {

    private String titular;
    private String cedula;
    private int edad;
    private boolean tieneDiscapacidad;
    private double saldo;
    private int viajesRealizados;
    private double totalRecargado;

    public static final double TARIFA_GENERAL = 0.45;

    public String getTitular() {
        return titular;
    }

    public TarjetaMetro(){
        this.titular = "ANOIMO";
        this.cedula = "1111111111";
        this.edad = 30;
        this.tieneDiscapacidad = false;
        this.saldo = 0;

    }

    public TarjetaMetro(String titular, String cedula, int edad, double saldo_inicial, boolean tieneDiscapacidad){
        setTitular(titular);
        setCedula(cedula);
        setEdad(edad);
        setTieneDiscapacidad(tieneDiscapacidad);
        if (saldo_inicial >= 0 && saldo_inicial <= 40){
            this.saldo = saldo_inicial;
        }else {
            System.out.println("el saldo es incorrecto");
            this.saldo = 0;
        }
    }
    public void setTitular(String titular) {
        if (titular.isBlank()){
            System.out.println("Titular incorrecto, asignado anonimo por defecto");
            this.titular = "ANONIMO";

        }else {
            this.titular = titular;
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula.length() == 10){

            this.cedula = cedula;
        }else{
            System.out.println("Cedula invalida");
            this.cedula = "0000000000";
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 5 || edad <= 110) {

            this.edad = edad;
        }else{
            System.out.println("Edad invalida");
            this.edad = 18;
        }
    }

    public boolean isTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public double getSaldo() {
        return saldo;
    }



    public int getViajesRealizados() {
        return viajesRealizados;
    }



    public double getTotalRecargado() {
        return totalRecargado;
    }

    public static void mostrarTraifas(){
        System.out.println("== TARIFAS METRO DE QUITO== ");
        System.out.println("Personas con discapcidad: $0.10 (tiene prioridad sobre la edad)");
        System.out.println("de 5 a 17 años o de 65 en adelante: $0.22");
        System.out.println("Resto de usarios: $0.45");
        System.out.println("Reglas: ");
        System.out.println("La recarga debe estar entre 1$ a 20 $");
        System.out.println(" El saldo y la tarjeta no pueden sueprar los 40$");
        System.out.println("Un viaje se permite cuando el saldo es mayor o igual a al atarifa");
    }

    public double calcularTarifa(){
        if (tieneDiscapacidad){
            return  0.10;

        }else if ((edad >= 5 && edad <= 17) || edad >= 65){
            return  0.22;
        }else {
            return TARIFA_GENERAL;
        }
    }

    public double calcularViajesDisponibles(){
        return saldo / calcularTarifa();
    }
    public double calcularViajesDisponibles(double montoAdicional){
        return (saldo + montoAdicional) / calcularTarifa();
    }

    public boolean recargar(double monto) {
        if(monto <1 || monto >20){
            System.out.println("MONTO NO PERMITIDO");
            return  false;
        } else if ((saldo + monto) > 40) {
            System.out.println("SALDO MAXIMO");
            return  false;
        }
        saldo += monto;
        totalRecargado += monto;
        System.out.println("Su nuevo saldo es: "+ saldo);
        return  true;
    }

    public boolean pagarViaje(){
        if (saldo >= calcularTarifa()){
            saldo -= calcularTarifa();
            viajesRealizados += 1;
            System.out.println("ACCESO PERMITIDO");
            System.out.println("Pago exitodo, saldo restante : $"+ saldo);
            return  true;
        }else {
            System.out.println("SALDO INSUFICIENTE");
            return  false;
        }
    }

    public void mostrarInformacion(){
        System.out.println("Titular: "+ titular);
        System.out.println("Cedula: "+ cedula);
        System.out.println("Edad:  "+ edad);
        System.out.println("Discapacidad: "+tieneDiscapacidad);
        System.out.println("Tarifa: "+ calcularTarifa());
        System.out.println("Saldo: "+ saldo);
        System.out.println("Viajes realizados: "+ viajesRealizados);
    }


}
