package cn.jon.crm.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class BeanUtil implements ApplicationContextAware{
	 private static ApplicationContext applicationContext;

	    /**
	     * ����bean���ֲ���bean
	     *
	     * @param beanName
	     * @return
	     */
	    public static Object getBean(String beanName)
	    {
	        return applicationContext.getBean(beanName);
	    }
	    /**
	     * ����bean���ֺ����Ͳ���
	     * @param beanName
	     * @param clazs
	     * @return
	     */
	    public static <T> T getBean(String beanName, Class<T> clazs)
	    {
	        return null == getBean(beanName) ? null : clazs.cast(getBean(beanName));
	    }

	    /**
	     *
	     * �õ�applicationContext������
	     *
	     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	     * @param applicationContext
	     * @throws BeansException
	     */	   
		public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			BeanUtil.applicationContext = applicationContext;
		}

}
