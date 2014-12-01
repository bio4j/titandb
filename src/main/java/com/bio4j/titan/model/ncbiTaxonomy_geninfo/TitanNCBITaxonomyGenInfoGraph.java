package com.bio4j.titan.model.ncbiTaxonomy_geninfo;

import com.bio4j.model.geninfo.GenInfoGraph;
import com.bio4j.model.ncbiTaxonomy.NCBITaxonomyGraph;
import com.bio4j.model.ncbiTaxonomy_geninfo.NCBITaxonomyGenInfoGraph;
import com.bio4j.titan.model.geninfo.TitanGenInfoGraph;
import com.bio4j.titan.model.ncbiTaxonomy.TitanNCBITaxonomyGraph;
import com.bio4j.titan.util.DefaultTitanGraph;
import com.thinkaurelius.titan.core.*;
import com.thinkaurelius.titan.core.schema.*;


/**
 Implementing the types with Titan
 @author <a href="mailto:ppareja@era7.com">Pablo Pareja Tobes</a>
 */
public final class TitanNCBITaxonomyGenInfoGraph
		extends
		NCBITaxonomyGenInfoGraph<DefaultTitanGraph, TitanVertex, VertexLabelMaker, TitanEdge, EdgeLabelMaker> {

	private DefaultTitanGraph rawGraph;
	private TitanNCBITaxonomyGraph ncbiTaxonomyRawGraph;
	private TitanGenInfoGraph genInfoRawGraph;

	//---------------RELATIONSHIPS---------------------------

	private EdgeLabel genInfoNCBITaxonLabel;
	private GenInfoNCBITaxonType genInfoNCBITaxonType;


	public TitanNCBITaxonomyGenInfoGraph(DefaultTitanGraph rawGraph, TitanNCBITaxonomyGraph titanNCBITaxonomyGraph, TitanGenInfoGraph titanGenInfoGraph) {
		super(rawGraph);
		this.rawGraph = rawGraph;
		this.ncbiTaxonomyRawGraph = titanNCBITaxonomyGraph;
		this.genInfoRawGraph = titanGenInfoGraph;
		initTypes();
		initIndices();
	}

	@Override
	public DefaultTitanGraph raw() {
		return rawGraph;
	}

	private void initTypes() {

		//-----------------------------------------------------------------------------------------
		//--------------------------------RELATIONSHIPS--------------------------------------------

		// genInfoNCBITaxonLabel = raw().titanLabelForEdgeType(new GenInfoNCBITaxonType((EdgeLabel) null));
		// genInfoNCBITaxonType = new GenInfoNCBITaxonType(genInfoNCBITaxonLabel);

	}

	private void initIndices() {

	}


	@Override
	public NCBITaxonomyGraph<DefaultTitanGraph, TitanVertex, VertexLabelMaker, TitanEdge, EdgeLabelMaker> ncbiTaxonomyGraph() {
		return ncbiTaxonomyRawGraph;
	}

	@Override
	public GenInfoGraph<DefaultTitanGraph, TitanVertex, VertexLabelMaker, TitanEdge, EdgeLabelMaker> genInfoGraph() {
		return genInfoRawGraph;
	}

	@Override
	public GenInfoNCBITaxonType GenInfoNCBITaxon() {
		return genInfoNCBITaxonType;
	}

}