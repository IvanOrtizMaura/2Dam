namespace CalculamanV2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        Random randomizer = new Random();

        int addend1;
        int addend2;

        int minuend1;
        int minuend2;

        int multiplicand1;
        int multiplicand2;

        int dividend1;
        int dividend2;

        int timeleft;

        public void Start()
        {
            addend1 = randomizer.Next(51);
            addend2 = randomizer.Next(51);

            plusLeftLabel.Text = addend1.ToString();
            plusRightLabel.Text = addend2.ToString();

            sum.Value = 0;

            minuend1 = randomizer.Next(1, 101);
            minuend2 = randomizer.Next(1, minuend1);
            minusLeftLabel.Text = minuend1.ToString();
            minusRightLabel.Text = minuend2.ToString();
            minus.Value = 0;

            multiplicand1 = randomizer.Next(2, 11);
            multiplicand2 = randomizer.Next(2, 11);
            multiplicationLeftLabel.Text = multiplicand1.ToString();
            multiplicationRightLabel.Text = multiplicand2.ToString();
            multiplication.Value = 0;

            dividend1 = randomizer.Next(2, 11);
            int temporaryQyotient = randomizer.Next(2, 11);
            dividend2 = dividend1 * temporaryQyotient;
            divisionLeftLabel.Text = dividend1.ToString();
            divisionRightLabel.Text = dividend2.ToString();
            division.Value = 0;

            timeleft = 60;
            timeLanble.Text = "60 segudos";
            timer1.Start();
        }

        private void startButton_Click(object sender, EventArgs e)
        {
            Start();
            startButton.Enabled = false;
        }
        private bool comprobacion()
        {
            if ((addend1 + addend2 == sum.Value) && 
                (minuend1 - minuend2 == minus.Value) &&
                (multiplicand1 * multiplicand2 == multiplication.Value) 
                && (dividend1 / dividend2 == division.Value))
                return true;
            else
                return false;
        }

        private void temporizadorTick(object sender, EventArgs e)
        {
            if (comprobacion()){
                timer1.Stop();
                MessageBox.Show("Has acertado todas las ecuaciones");
                startButton.Enabled = true;
            }else if(timeleft > 0)
            {
                timeleft -= 1;
                timeLanble.Text = timeleft + "segudos";
            }
            else
            {
                timer1.Stop();
                timeLanble.Text = "Game over";
                MessageBox.Show("No has acertado las ecuaciones a tiempo");
                startButton.Enabled = true;
            }
                 

        }
    }
}