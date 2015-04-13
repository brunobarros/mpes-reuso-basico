package myservlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

import servico.IServicoChamado;

public class Activator implements BundleActivator {
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		Collection<ServiceReference<IServicoChamado>> serviceReferences = bundleContext.getServiceReferences(IServicoChamado.class, null);
		
		List<IServicoChamado> servicosChamado = new ArrayList<IServicoChamado>();
		for (ServiceReference<IServicoChamado> serviceReference : serviceReferences) {
			servicosChamado.add(context.getService(serviceReference));
		}
		
		ServiceReference sr = context.getServiceReference(HttpService.class);
		HttpService http = (HttpService) context.getService(sr);
		if (http != null) {
			http.registerServlet("/chamados", new ChamadoServlet(servicosChamado), null, null);
			http.registerServlet("/chamados/tiposchamados", new TipoChamadoServlet(servicosChamado), null, null);
			System.out.println("Servlet(s) registrado(s)");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
}