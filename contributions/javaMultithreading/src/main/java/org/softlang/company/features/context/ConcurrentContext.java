package org.softlang.company.features.context;

import org.softlang.company.features.action.Action;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Run an action via submission to thread pool, i.e., concurrently
 */
public class ConcurrentContext implements Context {

	private static final int POOL_SIZE = 7;
	private ExecutorService pool;

	public ConcurrentContext() {
		pool = Executors.newFixedThreadPool(POOL_SIZE);
	}

	@Override
	public synchronized <X, Y> void execute(final Action<X, Y> action,
			final X param) {

			final ConcurrentContext context = this;
			pool.submit(new Runnable() {
				public void run() {
					action.execute(context, param);

				}
			});

	}

	public void waitForTermination() {
		try {
			pool.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}