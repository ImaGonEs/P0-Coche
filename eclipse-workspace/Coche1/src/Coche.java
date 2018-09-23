public class Coche {

		private double vel;
		private double dir;
		private double posx;
		private double posy;
		private String pil;
		
		
		public Coche(double vel, double dir, double posx, double posy, String pil) {
			super();
			this.vel = vel;
			this.dir = dir;
			this.posx = posx;
			this.posy = posy;
			this.pil = pil;
		}
		
		public Coche() {
			super();
			this.vel = 0;
			this.dir = 0;
			this.posx = 0;
			this.posy = 0;
			this.pil = null;
		}

		public double getVel() {
			return vel;
		}

		public void setVel(double vel) {
			this.vel = vel;
		}

		public double getDir() {
			return dir;
		}

		public void setDir(double dir) {
			this.dir = dir;
		}

		public double getPosx() {
			return posx;
		}

		public void setPosx(double posx) {
			this.posx = posx;
		}

		public double getPosy() {
			return posy;
		}

		public void setPosy(double posy) {
			this.posy = posy;
		}

		public String getPil() {
			return pil;
		}

		public void setPil(String pil) {
			this.pil = pil;
		}

		@Override
		public String toString() {
			return "Coche [vel=" + vel + ", dir=" + dir + ", posx=" + posx + ", posy=" + posy + ", pil=" + pil + "]";
		}
		
		
}