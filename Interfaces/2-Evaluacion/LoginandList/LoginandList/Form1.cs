namespace LoginandList
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        

        private void btnAñadir_Click(object sender, EventArgs e)
        {
            String nombre = txtNombre.Text + " " + txtApellidos.Text;

            if(nombre.Equals(" ")) {
                return;
            }
            else if (((String) comboTipo.SelectedItem).Equals("Administradro")) {
                if (!(listAdministradores.Items.Contains(nombre)))
                {
                    listAdministradores.Items.Add(nombre);
                    lblTotalAdmin.Text = listAdministradores.Items.Count.ToString();
                }
            }
            else{
                listUsuarios.Items.Add(nombre);
                lblTotalUsuario.Text = listUsuarios.Items.Count.ToString();
            }

        }

        private void btnCrear_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}