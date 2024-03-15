public class Alumno
{
        /**
         * Atributos
         */
        private int legajo;
        private int nroDocumento;
        private int nroTelefono;
        private String tipoDocumento;
        private String nombre;
        private String apellido;
        private String domicilio; // (calle, número, ciudad)
        private String usuarioSIU;
        private String claveSIU;
        /**
         * Interfaz
         */
        public void Alumno(int elLegajo, String elTipoDocumento, int elNroDocumento)
        {
                this.legajo = elLegajo;
                this.tipoDocumento = elTipoDocumento;
                this.nroDocumento = elNroDocumento;
        }
        public void Alumno(int elLegajo, String elTipoDocumento,
                        int elNroDocumento, int elNroTelefono, String elNombre,
                        String elApellido, String elDomicilio,
                        String elUsuarioSIU, String laClaveSIU)
        {
                this.legajo = elLegajo;
                this.nroDocumento = elNroDocumento;
                this.nroTelefono = elNroTelefono;
                this.tipoDocumento = elTipoDocumento;
                this.nombre = elNombre;
                this.apellido = elApellido;
                this.domicilio = elDomicilio;
                this.usuarioSIU = elUsuarioSIU;
                this.claveSIU = laClaveSIU;
        }
        public void setUsuarioSIU(String elUsuarioSIU)
        {
                this.usuarioSIU = elUsuarioSIU;
        }
        public void setClaveSIU(int laClaveSIU)
        {
                this.claveSIU = laClaveSIU;
        }
        public int getNroDocumento()
        {
                return (this.nroDocumento);
        }
        public String getNombre()
        {
                return (this.nombre);
        }
        public String getApellido()
        {
                return (this.apellido);
        }
        public boolean esClaveCorrecta(int laClaveSIU)
        {
                return (this.claveSIU == laClaveSIU);
        }
}
