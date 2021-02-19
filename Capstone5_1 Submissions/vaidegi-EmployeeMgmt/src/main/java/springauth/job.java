package springauth;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class job {

		@Id
		@Column(length = 10, nullable = false)
		private String jobid;
		
		@Column(length = 35, nullable = false)
		private String jobtitle;
		private Float minsalary;
		private Float maxsalary;
		
		public job(String jobid, String jobtitle, Float minsalary, Float maxsalary) {
			super();
			this.jobid = jobid;
			this.jobtitle = jobtitle;
			this.minsalary = minsalary;
			this.maxsalary = maxsalary;
		}
		
		public job() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getJobid() {
			return jobid;
		}

		public void setJobid(String jobid) {
			this.jobid = jobid;
		}

		public String getJobtitle() {
			return jobtitle;
		}

		public void setJobtitle(String jobtitle) {
			this.jobtitle = jobtitle;
		}

		public Float getMinsalary() {
			return minsalary;
		}

		public void setMinsalary(Float minsalary) {
			this.minsalary = minsalary;
		}

		public Float getMaxsalary() {
			return maxsalary;
		}

		public void setMaxsalary(Float maxsalary) {
			this.maxsalary = maxsalary;
		}

		@Override
		public String toString() {
			return "job [jobid=" + jobid + ", jobtitle=" + jobtitle + ", minsalary=" + minsalary + ", maxsalary="
					+ maxsalary + "]";
		}
		
		
		
		
	}



