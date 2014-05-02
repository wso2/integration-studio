/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;

import java.util.HashSet;

/**
 * This class provides some support for batching of EMF change notifications
 * while an execute/undo/redo is in progress on the CommandStack.
 */
public class CommandStackChangeBatcher extends AbstractSharedCommandStackListener {

	protected static boolean batchingChanges;

	// Note that when the batches are fired off to each adapter, the adapters
	// will
	// be finish()ed in a random order. (This is only bad if adapters depend on
	// their
	// behaviour being run before/after that of other adapters!).
	
	// TODO: is this being static, a problem now that we can share the
	// resourceSet across
	// multiple editors? What if adapters in more than one editor are responding
	// to the
	// changes?
	public static HashSet<IBatchedAdapter> liveBatchedAdapters = new HashSet<IBatchedAdapter>();

	static final IBatchedAdapter[] EMPTY = {};
	
	protected void startBatch() {
		if (batchingChanges) {
			// System.out.println("WARNING: Re-entered
			// CommandStackChangeBatcher.startBatch()! Merging with existing
			// batch!");
			return;
		}
		batchingChanges = true;
		// TODO: this is a little unsafe?. but it works for now.
		liveBatchedAdapters.clear();
	}
	protected void finishBatch() {
		batchingChanges = false;		
		for (IBatchedAdapter adapter : liveBatchedAdapters.toArray( EMPTY  )) {
            adapter.finish();
        }
		liveBatchedAdapters.clear();
	}

	/**
	 * @return whether we are batching changes.
	 */
	public static boolean isBatchingChanges() { 
		return batchingChanges; 
	}
	
	/**
	 * @param adapter
	 */
	public static void registerBatchChange (IBatchedAdapter adapter) {
		liveBatchedAdapters.add(adapter); 
	}

	@Override
	protected void startExecute() { 
		startBatch(); 
	}
	
	@Override
	protected void startRedo() { 
		startBatch(); 
	}
	
	@Override
	protected void startUndo() { 
		startBatch(); 
	}

	@Override
	protected void finishExecute() { 
		finishBatch(); 
	}
	
	@Override
	protected void finishRedo() { 
		finishBatch(); 
	}
	
	@Override
	protected void finishUndo() { 
		finishBatch(); 
	}
	
}
