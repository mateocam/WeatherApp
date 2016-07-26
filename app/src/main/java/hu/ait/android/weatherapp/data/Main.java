package hu.ait.android.weatherapp.data;

/**
 * Created by mateocar on 12/2/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

        @SerializedName("temp")
        @Expose
        private Integer temp;
        @SerializedName("pressure")
        @Expose
        private Integer pressure;
        @SerializedName("humidity")
        @Expose
        private Integer humidity;
        @SerializedName("temp_min")
        @Expose
        private Integer tempMin;
        @SerializedName("temp_max")
        @Expose
        private Integer tempMax;

        /**
         *
         * @return
         * The temp
         */
        public Integer getTemp() {
            return temp;
        }

        /**
         *
         * @param temp
         * The temp
         */
        public void setTemp(Integer temp) {
            this.temp = temp;
        }

        /**
         *
         * @return
         * The pressure
         */
        public Integer getPressure() {
            return pressure;
        }

        /**
         *
         * @param pressure
         * The pressure
         */
        public void setPressure(Integer pressure) {
            this.pressure = pressure;
        }

        /**
         *
         * @return
         * The humidity
         */
        public Integer getHumidity() {
            return humidity;
        }

        /**
         *
         * @param humidity
         * The humidity
         */
        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

        /**
         *
         * @return
         * The tempMin
         */
        public Integer getTempMin() {
            return tempMin;
        }

        /**
         *
         * @param tempMin
         * The temp_min
         */
        public void setTempMin(Integer tempMin) {
            this.tempMin = tempMin;
        }

        /**
         *
         * @return
         * The tempMax
         */
        public Integer getTempMax() {
            return tempMax;
        }

        /**
         *
         * @param tempMax
         * The temp_max
         */
        public void setTempMax(Integer tempMax) {
            this.tempMax = tempMax;
        }

    }
