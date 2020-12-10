package xin.jerome.sutdy.design.patterns.creational.builder;

/**
 * 台式电脑: 自己组装的台式机
 *
 * @author JeromeSoar
 * @since 2020年 12月 09日 16:19
 */
public class DesktopComputer {

    /**
     * 主机
     */
    private String host;
    /**
     * 显示器
     */
    private String displays;
    /**
     * 键盘
     */
    private String keyboard;
    /**
     * 鼠标
     */
    private String mouse;

    private DesktopComputer(DesktopComputerBuilder builder) {
        this.host = builder.host;
        this.displays = builder.displays;
        this.keyboard = builder.keyboard;
        this.mouse = builder.mouse;
    }

    public static DesktopComputerBuilder builder() {
        return new DesktopComputer.DesktopComputerBuilder();
    }

    /**
     * DesktopComputer 的构建者
     */
    public static class DesktopComputerBuilder{
        /** 主机 */
        private String host;
        /** 显示器 */
        private String displays;
        /** 键盘 */
        private String keyboard;
        /** 鼠标 */
        private String mouse;

        public DesktopComputerBuilder host(String host) {
            this.host = host;
            return this;
        }

        public DesktopComputerBuilder displays(String displays) {
            this.displays = displays;
            return this;
        }

        public DesktopComputerBuilder keyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public DesktopComputerBuilder mouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public DesktopComputer build() {
            return new DesktopComputer(this);
        }
    }

    @Override
    public String toString() {
        return "DesktopComputer{" +
                "host='" + host + '\'' +
                ", displays='" + displays + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}
