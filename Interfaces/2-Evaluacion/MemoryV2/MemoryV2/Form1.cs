namespace MemoryV2
{
    public partial class Form1 : Form
    {

        List<int> numbers = new List<int> { 1,1,2,2,3,3,4,4,5,5,6,6 };
        List<Color> colors = new List<Color> { Color.Red, Color.Blue, Color.Green, Color.Black, Color.Pink, Color.Violet};
        String firstChoice;
        String secondChoice;
        int tries;
        List<PictureBox> pictures = new List<PictureBox>();
        PictureBox picA;
        PictureBox picB;
        int totalTime = 30;
        int countDownTime;
        bool gameOver = false;


        public Form1()
        {
            InitializeComponent();
            LoadPictures();
        }

        private void TimerEvent(object sender, EventArgs e)
        {
            countDownTime--;

            lblTimeLeft.Text = "Time Left: " + countDownTime;

            if (countDownTime < 1)
            {
                GameOver("Times Up, You Lose");

                foreach (PictureBox x in pictures)
                {
                    if (x.Tag != null)
                    {
                        x.BackColor = Color.LightGray;
                    }
                }

            }
        }

        private void RestartGameEvent(object sender, EventArgs e)
        {
            RestartGame();
        }

        private void LoadPictures()
        {

            int leftPos = 20;
            int topPos = 20;
            int rows = 0;

            for (int i = 0; i < 12; i++)
            {
                PictureBox newPic = new PictureBox();
                newPic.Height = 50;
                newPic.Width = 50;
                newPic.BackColor = Color.LightGray;
                newPic.SizeMode = PictureBoxSizeMode.StretchImage;
                newPic.Click += NewPic_Click;
                pictures.Add(newPic);

                if (rows < 3)
                {
                    rows++;
                    newPic.Left = leftPos;
                    newPic.Top = topPos;
                    this.Controls.Add(newPic);
                    leftPos = leftPos + 60;
                    if (rows == 3)
                    {
                        leftPos = 20;
                        topPos += 60;
                        rows = 0;
                    }
                }

                RestartGame();
            }

        }

        private void NewPic_Click(object sender, EventArgs e)
        {
            if (gameOver)
            {
                return;
            }

            if (firstChoice == null)
            {
                picA = sender as PictureBox;
                if (picA.Tag != null && picA.Image == null)
                {
                    lblStatus.Text = (string)picA.Tag;
                    Color color = colors[Int32.Parse((string)picA.Tag)];
                    picA.BackColor = color;
                    // picA.BackColor = Color.Blue;
                    //picA.Image = Image.FromFile("Fotos/" + (string)picA.Tag + ".png");
                    firstChoice = (string)picA.Tag;
                }
            } else if (secondChoice == null)
            {
                picB = sender as PictureBox;
                if (picB.Tag != null && picB.Image == null)
                {
                    lblStatus.Text = (string)picB.Tag;
                    Color color = colors[Int32.Parse((string)picB.Tag)];
                    picB.BackColor = color;
                    // picB.BackColor = Color.Blue;
                    // picB.Image = Image.FromFile("Fotos/" + (string)picB.Tag + ".png");
                    secondChoice = (string)picB.Tag;
                }
            } else
            {
                CheckPictures(picA, picB);
            }
        }

        private void RestartGame()
        {
            // randomise the original list
            var randomList = numbers.OrderBy(x => Guid.NewGuid()).ToList();
            // assign the random list to the original
            numbers = randomList;

            for (int i = 0; i < pictures.Count; i++)
            {
                pictures[i].Image = null;
                pictures[i].Tag = numbers[i].ToString();
            }

            tries = 0;
            lblStatus.Text = "Mismatched: " + tries + " times.";
            lblTimeLeft.Text = "Time left: " + totalTime;
            gameOver = false;
            GameTimer.Start();
            countDownTime = totalTime;
        }

        private void CheckPictures(PictureBox A, PictureBox B)
        {
            if (firstChoice == secondChoice)
            {
                A.Tag = null;
                B.Tag = null;
            } else
            {
                tries++;
                lblStatus.Text = "Mismatched " + tries + " times.";
            }

            firstChoice = null;
            secondChoice = null;

            foreach (PictureBox pics in pictures.ToList())
            {
                if (pics.Tag != null)
                {
                    pics.BackColor = Color.LightGray;
                }
            }

            if (pictures.All(o => o.Tag == pictures[0].Tag))
            {
                GameOver("Great Work, You Win!!");
            }
        }

        private void GameOver(string msg)
        {
            GameTimer.Stop();
            gameOver = true;
            MessageBox.Show(msg + " Click Restart to Play Again.");
        }
    }
}