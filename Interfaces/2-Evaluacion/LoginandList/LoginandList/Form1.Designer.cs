namespace LoginandList
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnAñadir = new System.Windows.Forms.Button();
            this.btnCrear = new System.Windows.Forms.Button();
            this.lblTipo = new System.Windows.Forms.Label();
            this.lblNombre = new System.Windows.Forms.Label();
            this.lblApellidos = new System.Windows.Forms.Label();
            this.txtApellidos = new System.Windows.Forms.TextBox();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.comboTipo = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.listAdministradores = new System.Windows.Forms.ListBox();
            this.listUsuarios = new System.Windows.Forms.ListBox();
            this.lblTotalAdmin = new System.Windows.Forms.Label();
            this.lblTotalUsuario = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnAñadir
            // 
            this.btnAñadir.Location = new System.Drawing.Point(38, 36);
            this.btnAñadir.Name = "btnAñadir";
            this.btnAñadir.Size = new System.Drawing.Size(75, 23);
            this.btnAñadir.TabIndex = 0;
            this.btnAñadir.Text = "Añadir";
            this.btnAñadir.UseVisualStyleBackColor = true;
            this.btnAñadir.Click += new System.EventHandler(this.btnAñadir_Click);
            // 
            // btnCrear
            // 
            this.btnCrear.Location = new System.Drawing.Point(466, 36);
            this.btnCrear.Name = "btnCrear";
            this.btnCrear.Size = new System.Drawing.Size(75, 23);
            this.btnCrear.TabIndex = 1;
            this.btnCrear.Text = "Cerrar";
            this.btnCrear.UseVisualStyleBackColor = true;
            this.btnCrear.Click += new System.EventHandler(this.btnCrear_Click);
            // 
            // lblTipo
            // 
            this.lblTipo.AutoSize = true;
            this.lblTipo.Location = new System.Drawing.Point(62, 126);
            this.lblTipo.Name = "lblTipo";
            this.lblTipo.Size = new System.Drawing.Size(30, 15);
            this.lblTipo.TabIndex = 2;
            this.lblTipo.Text = "Tipo";
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Location = new System.Drawing.Point(392, 126);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(51, 15);
            this.lblNombre.TabIndex = 3;
            this.lblNombre.Text = "Nombre";
            // 
            // lblApellidos
            // 
            this.lblApellidos.AutoSize = true;
            this.lblApellidos.Location = new System.Drawing.Point(536, 126);
            this.lblApellidos.Name = "lblApellidos";
            this.lblApellidos.Size = new System.Drawing.Size(56, 15);
            this.lblApellidos.TabIndex = 4;
            this.lblApellidos.Text = "Apellidos";
            // 
            // txtApellidos
            // 
            this.txtApellidos.Location = new System.Drawing.Point(514, 158);
            this.txtApellidos.Name = "txtApellidos";
            this.txtApellidos.Size = new System.Drawing.Size(100, 23);
            this.txtApellidos.TabIndex = 5;
            // 
            // txtNombre
            // 
            this.txtNombre.Location = new System.Drawing.Point(370, 158);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(100, 23);
            this.txtNombre.TabIndex = 6;
            // 
            // comboTipo
            // 
            this.comboTipo.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboTipo.FormattingEnabled = true;
            this.comboTipo.Items.AddRange(new object[] {
            "Administradro",
            "Usuario"});
            this.comboTipo.Location = new System.Drawing.Point(26, 158);
            this.comboTipo.Name = "comboTipo";
            this.comboTipo.Size = new System.Drawing.Size(121, 23);
            this.comboTipo.TabIndex = 7;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 216);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(135, 15);
            this.label1.TabIndex = 8;
            this.label1.Text = "Lista de administradores";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(370, 216);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(94, 15);
            this.label2.TabIndex = 9;
            this.label2.Text = "Lista de usuarios";
            // 
            // listAdministradores
            // 
            this.listAdministradores.FormattingEnabled = true;
            this.listAdministradores.ItemHeight = 15;
            this.listAdministradores.Location = new System.Drawing.Point(13, 244);
            this.listAdministradores.Name = "listAdministradores";
            this.listAdministradores.Size = new System.Drawing.Size(171, 139);
            this.listAdministradores.TabIndex = 10;
            // 
            // listUsuarios
            // 
            this.listUsuarios.FormattingEnabled = true;
            this.listUsuarios.ItemHeight = 15;
            this.listUsuarios.Location = new System.Drawing.Point(370, 244);
            this.listUsuarios.Name = "listUsuarios";
            this.listUsuarios.Size = new System.Drawing.Size(194, 139);
            this.listUsuarios.TabIndex = 11;
            // 
            // lblTotalAdmin
            // 
            this.lblTotalAdmin.AutoSize = true;
            this.lblTotalAdmin.Location = new System.Drawing.Point(38, 397);
            this.lblTotalAdmin.Name = "lblTotalAdmin";
            this.lblTotalAdmin.Size = new System.Drawing.Size(32, 15);
            this.lblTotalAdmin.TabIndex = 12;
            this.lblTotalAdmin.Text = "Total";
            // 
            // lblTotalUsuario
            // 
            this.lblTotalUsuario.AutoSize = true;
            this.lblTotalUsuario.Location = new System.Drawing.Point(370, 397);
            this.lblTotalUsuario.Name = "lblTotalUsuario";
            this.lblTotalUsuario.Size = new System.Drawing.Size(32, 15);
            this.lblTotalUsuario.TabIndex = 13;
            this.lblTotalUsuario.Text = "Total";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(624, 450);
            this.Controls.Add(this.lblTotalUsuario);
            this.Controls.Add(this.lblTotalAdmin);
            this.Controls.Add(this.listUsuarios);
            this.Controls.Add(this.listAdministradores);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboTipo);
            this.Controls.Add(this.txtNombre);
            this.Controls.Add(this.txtApellidos);
            this.Controls.Add(this.lblApellidos);
            this.Controls.Add(this.lblNombre);
            this.Controls.Add(this.lblTipo);
            this.Controls.Add(this.btnCrear);
            this.Controls.Add(this.btnAñadir);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button btnAñadir;
        private Button btnCrear;
        private Label lblTipo;
        private Label lblNombre;
        private Label lblApellidos;
        private TextBox txtApellidos;
        private TextBox txtNombre;
        private ComboBox comboTipo;
        private Label label1;
        private Label label2;
        private ListBox listAdministradores;
        private ListBox listUsuarios;
        private Label lblTotalAdmin;
        private Label lblTotalUsuario;
    }
}