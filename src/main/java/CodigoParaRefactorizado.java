
public class CodigoParaRefactorizado {
    
    private static final double IVA = 0.21; // Constante configurable

    private double calcularIva(double precioBase) {
        return precioBase * IVA;
    }

    public double calcularPrecioConIva(double precioBase) {
        return precioBase + calcularIva(precioBase);
    }

    public double calcularPrecioConIvaYDescuento(double precioBase, double porcentajeDescuento) {
        double precioConIva = calcularPrecioConIva(precioBase);
        return precioConIva - (precioConIva * porcentajeDescuento / 100);
    }

    public int diasMes(int mes, int anio) {
        int[] diasPorMes = { 31, (esBisiesto(anio) ? 29 : 28), 31, 30, 31, 30, 
                             31, 31, 30, 31, 30, 31 };
        return (mes >= 1 && mes <= 12) ? diasPorMes[mes - 1] : -1; // Retorna -1 si el mes no es válido
    }

    private boolean esBisiesto(int anio) {
        return (anio % 400 == 0) || ((anio % 4 == 0) && (anio % 100 != 0));
    }

    public double subirPrecio(double precioBase, double subida) {
        double nuevoPrecioBase = precioBase + subida;
        return calcularPrecioConIva(nuevoPrecioBase);
    }

  
    public static void main(String[] args) {
        CodigoParaRefactorizado obj = new CodigoParaRefactorizado();

        double precioBase = 100.0;
        double precioConIva = obj.calcularPrecioConIva(precioBase);
        System.out.println("Precio con IVA: " + precioConIva);

        double precioConDescuento = obj.calcularPrecioConIvaYDescuento(precioBase, 10);
        System.out.println("Precio con IVA y 10% de descuento: " + precioConDescuento);

        int diasFebrero2024 = obj.diasMes(2, 2024);
        System.out.println("Días en febrero 2024: " + diasFebrero2024);

        double nuevoPrecio = obj.subirPrecio(precioBase, 20);
        System.out.println("Nuevo precio con IVA después de subir 20: " + nuevoPrecio);
    }
}
