namespace Calculaman
{
    public partial class CalculaMan : Form
    {
        Random randomizer = new Random();

        int num1;
        int num2;

        public void Start()
        {
            num1 = randomizer.Next(101);
            num2 = randomizer.Next(101);

            plusLeftLabel.Text = num1.ToString();
            plusRightLabel.Text = num2.ToString();

            sum.Value= 0;

        }
        
    }
}