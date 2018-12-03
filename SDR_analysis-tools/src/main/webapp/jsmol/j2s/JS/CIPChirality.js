Clazz.declarePackage ("JS");
Clazz.load (["JU.Lst", "$.V3"], "JS.CIPChirality", ["java.util.Arrays", "$.Hashtable", "JU.BS", "$.Measure", "$.P4", "$.PT", "JU.BSUtil", "$.Logger", "JV.JC"], function () {
c$ = Clazz.decorateAsClass (function () {
this.ptID = 0;
this.root = null;
this.currentRule = 1;
this.lstSmallRings = null;
this.bsAtropisomeric = null;
this.bsKekuleAmbiguous = null;
this.bsAzacyclic = null;
this.vNorm = null;
this.vNorm2 = null;
this.vTemp = null;
this.allowRule1bAlkenes = true;
if (!Clazz.isClassDefined ("JS.CIPChirality.CIPAtom")) {
JS.CIPChirality.$CIPChirality$CIPAtom$ ();
}
Clazz.instantialize (this, arguments);
}, JS, "CIPChirality");
Clazz.prepareFields (c$, function () {
this.lstSmallRings =  new JU.Lst ();
this.vNorm =  new JU.V3 ();
this.vNorm2 =  new JU.V3 ();
this.vTemp =  new JU.V3 ();
});
Clazz.defineMethod (c$, "getRuleName", 
function () {
return JV.JC.getCIPRuleName (this.currentRule);
});
Clazz.makeConstructor (c$, 
function () {
});
Clazz.defineMethod (c$, "init", 
 function () {
this.ptID = 0;
this.lstSmallRings.clear ();
this.bsKekuleAmbiguous = null;
this.bsAtropisomeric =  new JU.BS ();
});
Clazz.defineMethod (c$, "getChiralityForAtoms", 
function (atoms, bsAtoms, bsAtropisomeric, bsHelixM, bsHelixP) {
if (bsAtoms.isEmpty ()) return;
this.init ();
this.bsAtropisomeric = (bsAtropisomeric == null ?  new JU.BS () : bsAtropisomeric);
var bs = JU.BSUtil.copy (bsAtoms);
this.lstSmallRings =  new JU.Lst ();
while (!bs.isEmpty ()) this.getSmallRings (atoms[bs.nextSetBit (0)], bs);

this.bsKekuleAmbiguous = this.getKekule (atoms);
this.bsAzacyclic = this.getAzacyclic (atoms, bsAtoms);
var bsToDo = JU.BSUtil.copy (bsAtoms);
var haveAlkenes = this.preFilterAtomList (atoms, bsToDo);
for (var i = bsToDo.nextSetBit (0); i >= 0; i = bsToDo.nextSetBit (i + 1)) {
var a = atoms[i];
a.setCIPChirality (0);
this.ptID = 0;
var c = this.getAtomChiralityLimited (a, null, null, 8);
a.setCIPChirality (c == 0 ? 3 : c | ((this.currentRule - 1) << 5));
}
if (haveAlkenes) {
var lstEZ =  new JU.Lst ();
for (var i = bsToDo.nextSetBit (0); i >= 0; i = bsToDo.nextSetBit (i + 1)) this.getAtomBondChirality (atoms[i], lstEZ, bsToDo);

if (this.lstSmallRings.size () > 0 && lstEZ.size () > 0) this.clearSmallRingEZ (atoms, lstEZ);
if (bsHelixM != null) for (var i = bsHelixM.nextSetBit (0); i >= 0; i = bsHelixM.nextSetBit (i + 1)) atoms[i].setCIPChirality (17);

if (bsHelixP != null) for (var i = bsHelixP.nextSetBit (0); i >= 0; i = bsHelixP.nextSetBit (i + 1)) atoms[i].setCIPChirality (18);

}if (JU.Logger.debugging) {
JU.Logger.info ("sp2-aromatic = " + this.bsKekuleAmbiguous);
JU.Logger.info ("smallRings = " + JU.PT.toJSON (null, this.lstSmallRings));
}}, "~A,JU.BS,JU.BS,JU.BS,JU.BS");
Clazz.defineMethod (c$, "getAzacyclic", 
 function (atoms, bsAtoms) {
var bsAza = null;
for (var i = bsAtoms.nextSetBit (0); i >= 0; i = bsAtoms.nextSetBit (i + 1)) {
var atom = atoms[i];
if (atom.getElementNumber () != 7 || atom.getCovalentBondCount () != 3 || this.bsKekuleAmbiguous.get (i)) continue;
var nRings =  new JU.Lst ();
for (var j = this.lstSmallRings.size (); --j >= 0; ) {
var bsRing = this.lstSmallRings.get (j);
if (bsRing.get (i)) nRings.addLast (bsRing);
}
var nr = nRings.size ();
if (nr < 2) continue;
var bsSubs =  new JU.BS ();
var bonds = atom.getEdges ();
for (var b = bonds.length; --b >= 0; ) if (bonds[b].isCovalent ()) bsSubs.set (bonds[b].getOtherNode (atom).getIndex ());

var bsBoth =  new JU.BS ();
var bsAll =  new JU.BS ();
for (var j = 0; j < nr - 1 && bsAll != null; j++) {
var bs1 = nRings.get (j);
for (var k = j + 1; k < nr && bsAll != null; k++) {
var bs2 = nRings.get (k);
JU.BSUtil.copy2 (bs1, bsBoth);
bsBoth.and (bs2);
if (bsBoth.cardinality () > 2) {
JU.BSUtil.copy2 (bs1, bsAll);
bsAll.or (bs2);
bsAll.and (bsSubs);
if (bsAll.cardinality () == 3) {
if (bsAza == null) bsAza =  new JU.BS ();
bsAza.set (i);
bsAll = null;
}}}
}
}
return bsAza;
}, "~A,JU.BS");
Clazz.defineMethod (c$, "preFilterAtomList", 
 function (atoms, bsToDo) {
var haveAlkenes = false;
for (var i = bsToDo.nextSetBit (0); i >= 0; i = bsToDo.nextSetBit (i + 1)) {
if (!this.couldBeChiralAtom (atoms[i])) {
bsToDo.clear (i);
continue;
}if (!haveAlkenes && this.couldBeChiralAlkene (atoms[i], null) != -1) haveAlkenes = true;
}
return haveAlkenes;
}, "~A,JU.BS");
Clazz.defineMethod (c$, "couldBeChiralAtom", 
 function (a) {
var mustBePlanar = false;
switch (a.getCovalentBondCount ()) {
default:
System.out.println ("???? too many bonds! " + a);
return false;
case 0:
return false;
case 1:
return false;
case 2:
return a.getElementNumber () == 7;
case 3:
switch (a.getElementNumber ()) {
case 7:
if (this.bsAzacyclic != null && this.bsAzacyclic.get (a.getIndex ())) break;
return false;
case 6:
mustBePlanar = true;
break;
case 15:
case 16:
case 33:
case 34:
case 51:
case 52:
case 83:
case 84:
break;
case 4:
break;
default:
return false;
}
break;
case 4:
break;
}
var edges = a.getEdges ();
var nH = 0;
var haveDouble = false;
for (var j = edges.length; --j >= 0; ) {
if (mustBePlanar && edges[j].getCovalentOrder () == 2) haveDouble = true;
if (edges[j].getOtherNode (a).getIsotopeNumber () == 1) nH++;
}
return (nH < 2 && (haveDouble || mustBePlanar == Math.abs (this.getTrigonality (a, this.vNorm)) < 0.2));
}, "JU.SimpleNode");
Clazz.defineMethod (c$, "couldBeChiralAlkene", 
 function (a, b) {
switch (a.getCovalentBondCount ()) {
default:
return -1;
case 2:
if (a.getElementNumber () != 7) return -1;
break;
case 3:
if (!this.isFirstRow (a)) return -1;
break;
}
var bonds = a.getEdges ();
var n = 0;
for (var i = bonds.length; --i >= 0; ) if (bonds[i].getCovalentOrder () == 2) {
if (++n > 1) return 17;
var other = bonds[i].getOtherNode (a);
if (!this.isFirstRow (other)) return -1;
if (b != null && (other !== b || b.getCovalentBondCount () == 1)) {
return -1;
}}
return 5;
}, "JU.SimpleNode,JU.SimpleNode");
Clazz.defineMethod (c$, "isFirstRow", 
function (a) {
var n = a.getElementNumber ();
return (n > 2 && n <= 10);
}, "JU.SimpleNode");
Clazz.defineMethod (c$, "getKekule", 
 function (atoms) {
var nRings = this.lstSmallRings.size ();
var bs =  new JU.BS ();
var bsDone =  new JU.BS ();
for (var i = nRings; --i >= 0; ) {
if (bsDone.get (i)) continue;
var bsRing = this.lstSmallRings.get (i);
if (bsRing.cardinality () != 6) {
bsDone.set (i);
continue;
}var nPI = 0;
for (var j = bsRing.nextSetBit (0); j >= 0; j = bsRing.nextSetBit (j + 1)) {
var a = atoms[j];
if (bs.get (a.getIndex ())) {
nPI++;
continue;
}var nb = a.getCovalentBondCount ();
if (nb == 3 || nb == 2) {
var bonds = a.getEdges ();
for (var k = bonds.length; --k >= 0; ) {
var b = bonds[k];
if (b.getCovalentOrder () != 2) continue;
if (bsRing.get (b.getOtherNode (a).getIndex ())) {
nPI++;
break;
}}
}}
if (nPI == 6) {
bs.or (bsRing);
bsDone.set (i);
i = nRings;
}}
return bs;
}, "~A");
Clazz.defineMethod (c$, "getSmallRings", 
 function (atom, bs) {
this.root = Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (atom, null, false, false, false);
this.addSmallRings (this.root, bs);
}, "JU.SimpleNode,JU.BS");
Clazz.defineMethod (c$, "addSmallRings", 
 function (a, bs) {
if (a == null || a.atom == null || a.sphere > 7) return;
if (bs != null) bs.clear (a.atom.getIndex ());
if (a.isTerminal || a.isDuplicate || a.atom.getCovalentBondCount () > 4) return;
var atom2;
var pt = 0;
var bonds = a.atom.getEdges ();
for (var i = bonds.length; --i >= 0; ) {
var bond = bonds[i];
if (!bond.isCovalent () || (atom2 = bond.getOtherNode (a.atom)).getCovalentBondCount () == 1 || a.parent != null && atom2 === a.parent.atom) continue;
var r = a.addAtom (pt++, atom2, false, false, false);
if (r.isDuplicate) r.updateRingList ();
}
for (var i = 0; i < pt; i++) {
this.addSmallRings (a.atoms[i], bs);
}
}, "JS.CIPChirality.CIPAtom,JU.BS");
Clazz.defineMethod (c$, "clearSmallRingEZ", 
 function (atoms, lstEZ) {
for (var j = this.lstSmallRings.size (); --j >= 0; ) this.lstSmallRings.get (j).andNot (this.bsAtropisomeric);

for (var i = lstEZ.size (); --i >= 0; ) {
var ab = lstEZ.get (i);
for (var j = this.lstSmallRings.size (); --j >= 0; ) {
var ring = this.lstSmallRings.get (j);
if (ring.get (ab[0]) && ring.get (ab[1])) {
atoms[ab[0]].setCIPChirality (3);
atoms[ab[1]].setCIPChirality (3);
}}
}
}, "~A,JU.Lst");
Clazz.defineMethod (c$, "getTrigonality", 
function (a, vNorm) {
var pts =  new Array (4);
var bonds = a.getEdges ();
for (var n = bonds.length, i = n, pt = 0; --i >= 0 && pt < 4; ) if (bonds[i].isCovalent ()) pts[pt++] = bonds[i].getOtherNode (a).getXYZ ();

var plane = JU.Measure.getPlaneThroughPoints (pts[0], pts[1], pts[2], vNorm, this.vTemp,  new JU.P4 ());
return JU.Measure.distanceToPlane (plane, (pts[3] == null ? a.getXYZ () : pts[3]));
}, "JU.SimpleNode,JU.V3");
Clazz.defineMethod (c$, "getAtomBondChirality", 
 function (atom, lstEZ, bsToDo) {
var index = atom.getIndex ();
var bonds = atom.getEdges ();
var c = 0;
var isAtropic = this.bsAtropisomeric.get (index);
for (var j = bonds.length; --j >= 0; ) {
var bond = bonds[j];
var atom1;
var index1;
if (isAtropic) {
atom1 = bonds[j].getOtherNode (atom);
index1 = atom1.getIndex ();
if (!this.bsAtropisomeric.get (index1)) continue;
c = this.setBondChirality (atom, atom1, atom, atom1, true, 8);
} else if (bond.getCovalentOrder () == 2) {
atom1 = this.getLastCumuleneAtom (bond, atom, null, null);
index1 = atom1.getIndex ();
if (index1 < index) continue;
c = this.getBondChiralityLimited (bond, atom, 8);
} else {
continue;
}if (c != 0) {
if (!isAtropic) lstEZ.addLast ( Clazz.newIntArray (-1, [index, index1]));
bsToDo.clear (index);
bsToDo.clear (index1);
}if (isAtropic) break;
}
}, "JU.SimpleNode,JU.Lst,JU.BS");
Clazz.defineMethod (c$, "getLastCumuleneAtom", 
 function (bond, atom, nSP2, parents) {
var atom2 = bond.getOtherNode (atom);
if (parents != null) {
parents[0] = atom2;
parents[1] = atom;
}if (nSP2 != null) nSP2[0] = 2;
var ppt = 0;
while (true) {
if (atom2.getCovalentBondCount () != 2) return atom2;
var edges = atom2.getEdges ();
for (var i = edges.length; --i >= 0; ) {
var atom3 = (bond = edges[i]).getOtherNode (atom2);
if (atom3 === atom) continue;
if (bond.getCovalentOrder () != 2) return atom2;
if (parents != null) {
if (ppt == 0) {
parents[0] = atom2;
ppt = 1;
}parents[1] = atom2;
}if (nSP2 != null) nSP2[0]++;
atom = atom2;
atom2 = atom3;
break;
}
}
}, "JU.SimpleEdge,JU.SimpleNode,~A,~A");
Clazz.defineMethod (c$, "getAtomChiralityLimited", 
 function (atom, cipAtom, parent, ruleMax) {
var rs = 0;
var isChiral = false;
var isAlkene = false;
try {
if (cipAtom == null) {
cipAtom = Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (atom, null, isAlkene, false, false);
var nSubs = atom.getCovalentBondCount ();
var elemNo = atom.getElementNumber ();
isAlkene = (nSubs == 3 && elemNo <= 10 && !cipAtom.isTrigonalPyramidal);
if (nSubs != (parent == null ? 4 : 3) - (nSubs == 3 && !isAlkene ? 1 : 0)) return rs;
} else {
atom = cipAtom.atom;
isAlkene = cipAtom.isAlkene;
}this.root = cipAtom;
cipAtom.parent = parent;
if (parent != null) cipAtom.htPathPoints = parent.htPathPoints;
this.currentRule = 1;
if (cipAtom.setNode ()) {
for (this.currentRule = 1; this.currentRule <= ruleMax; this.currentRule++) {
if (JU.Logger.debugging) JU.Logger.info ("-Rule " + this.getRuleName () + " CIPChirality for " + cipAtom + "-----");
if (this.currentRule == 5) cipAtom.createAuxiliaryRule4Data (null, null);
isChiral = cipAtom.sortSubstituents (0);
if (JU.Logger.debugging) {
JU.Logger.info (this.currentRule + ">>>>" + cipAtom);
for (var i = 0; i < cipAtom.bondCount; i++) {
if (cipAtom.atoms[i] != null) JU.Logger.info (cipAtom.atoms[i] + " " + Integer.toHexString (cipAtom.priorities[i]));
}
}if (cipAtom.achiral) {
isChiral = false;
break;
}if (this.currentRule == 8) cipAtom.isPseudo = cipAtom.canBePseudo;
if (isChiral) {
rs = (!isAlkene ? cipAtom.checkHandedness () : cipAtom.atoms[0].isDuplicate ? 2 : 1);
if (!isAlkene && cipAtom.isPseudo && cipAtom.canBePseudo) {
this.currentRule = 8;
rs = rs | 8;
}if (JU.Logger.debugging) JU.Logger.info (atom + " " + JV.JC.getCIPChiralityName (rs) + " by Rule " + this.getRuleName () + "\n----------------------------------");
break;
}}
}} catch (e) {
System.out.println (e + " in CIPChirality");
{
alert(e);
}return 3;
}
return rs;
}, "JU.SimpleNode,JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,~N");
Clazz.defineMethod (c$, "getBondChiralityLimited", 
 function (bond, a, ruleMax) {
if (JU.Logger.debugging) JU.Logger.info ("get Bond Chirality " + bond);
if (a == null) a = bond.getOtherNode (null);
if (this.couldBeChiralAlkene (a, bond.getOtherNode (a)) == -1) return 0;
var nSP2 =  Clazz.newIntArray (1, 0);
var parents =  new Array (2);
var b = this.getLastCumuleneAtom (bond, a, nSP2, parents);
var isAxial = nSP2[0] % 2 == 1;
return this.setBondChirality (a, parents[0], parents[1], b, isAxial, ruleMax);
}, "JU.SimpleEdge,JU.SimpleNode,~N");
Clazz.defineMethod (c$, "setBondChirality", 
 function (a, pa, pb, b, isAxial, ruleMax) {
var a1 = Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (a, null, true, false, false);
var atop = this.getAlkeneEndTopPriority (a1, pa, isAxial, ruleMax);
var ruleA = this.currentRule;
var b2 = Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (b, null, true, false, false);
var btop = this.getAlkeneEndTopPriority (b2, pb, isAxial, ruleMax);
var ruleB = this.currentRule;
var c = (atop >= 0 && btop >= 0 ? this.getEneChirality (b2.atoms[btop], b2, a1, a1.atoms[atop], isAxial, true) : 0);
if (c != 0 && (isAxial || !this.bsAtropisomeric.get (a.getIndex ()) && !this.bsAtropisomeric.get (b.getIndex ()))) {
a.setCIPChirality (c | ((ruleA - 1) << 5));
b.setCIPChirality (c | ((ruleB - 1) << 5));
if (JU.Logger.debugging) JU.Logger.info (a + "-" + b + " " + JV.JC.getCIPChiralityName (c));
}return c;
}, "JU.SimpleNode,JU.SimpleNode,JU.SimpleNode,JU.SimpleNode,~B,~N");
Clazz.defineMethod (c$, "getEneChirality", 
function (top1, end1, end2, top2, isAxial, allowPseudo) {
return (top1 == null || top2 == null || top1.atom == null || top2.atom == null ? 0 : isAxial ? (this.isPos (top1, end1, end2, top2) ? 18 : 17) | (allowPseudo && (end2.ties == null) != (end1.ties == null) ? 8 : 0) : (this.isCis (top1, end1, end2, top2) ? 5 : 6));
}, "JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,~B,~B");
Clazz.defineMethod (c$, "getAlkeneEndTopPriority", 
 function (a, pa, isAxial, ruleMax) {
a.canBePseudo = a.isAxialRoot = isAxial;
return this.getAtomChiralityLimited (a.atom, a, Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (pa, null, true, false, false), ruleMax) - 1;
}, "JS.CIPChirality.CIPAtom,JU.SimpleNode,~B,~N");
Clazz.defineMethod (c$, "isCis", 
function (a, b, c, d) {
JU.Measure.getNormalThroughPoints (a.atom.getXYZ (), b.atom.getXYZ (), c.atom.getXYZ (), this.vNorm, this.vTemp);
var vNorm2 =  new JU.V3 ();
JU.Measure.getNormalThroughPoints (b.atom.getXYZ (), c.atom.getXYZ (), d.atom.getXYZ (), vNorm2, this.vTemp);
return (this.vNorm.dot (vNorm2) > 0);
}, "JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "isPos", 
function (a, b, c, d) {
var angle = JU.Measure.computeTorsion (a.atom.getXYZ (), b.atom.getXYZ (), c.atom.getXYZ (), d.atom.getXYZ (), true);
return (angle > 0);
}, "JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom");
c$.$CIPChirality$CIPAtom$ = function () {
Clazz.pu$h(self.c$);
c$ = Clazz.decorateAsClass (function () {
Clazz.prepareCallback (this, arguments);
this.atom = null;
this.id = 0;
this.parent = null;
this.rootSubstituent = null;
this.elemNo = 0;
this.massNo = 0;
this.sphere = 0;
this.bsPath = null;
this.myPath = "";
this.rootDistance = 0;
this.nAtoms = 0;
this.nPriorities = 0;
this.h1Count = 0;
this.auxChirality = "~";
this.isSet = false;
this.isDuplicate = true;
this.isTerminal = false;
this.isAlkene = false;
this.alkeneParent = null;
this.alkeneChild = null;
this.spiroEnd = null;
this.isAlkeneAtom2 = false;
this.doCheckPseudo = false;
this.isPseudo = false;
this.achiral = false;
this.bondCount = 0;
this.atoms = null;
this.priorities = null;
this.rule4List = null;
this.atomIndex = 0;
this.auxEZ = -1;
this.canBePseudo = true;
this.ties = null;
this.isAxialRoot = false;
this.nextSP2 = null;
this.nextChiralBranch = null;
this.rule4Count = null;
this.priority = 0;
this.htPathPoints = null;
this.isTrigonalPyramidal = false;
this.isKekuleAmbiguous = false;
this.sp2Duplicate = false;
this.isEvenEne = true;
Clazz.instantialize (this, arguments);
}, JS.CIPChirality, "CIPAtom", null, [Comparable, Cloneable]);
Clazz.prepareFields (c$, function () {
this.atoms =  new Array (4);
this.priorities =  Clazz.newIntArray (4, 0);
});
Clazz.makeConstructor (c$, 
function () {
});
Clazz.defineMethod (c$, "create", 
function (a, b, c, d, e) {
this.id = ++this.b$["JS.CIPChirality"].ptID;
this.parent = b;
if (a == null) return this;
this.isAlkene = c;
this.atom = a;
this.atomIndex = a.getIndex ();
this.isKekuleAmbiguous = (this.b$["JS.CIPChirality"].bsKekuleAmbiguous != null && this.b$["JS.CIPChirality"].bsKekuleAmbiguous.get (this.atomIndex));
this.elemNo = (d && this.isKekuleAmbiguous ? b.getKekuleElementNumber () : a.getElementNumber ());
this.massNo = a.getNominalMass ();
this.bondCount = a.getCovalentBondCount ();
this.isTrigonalPyramidal = (this.bondCount == 3 && !c && (this.elemNo > 10 || this.b$["JS.CIPChirality"].bsAzacyclic != null && this.b$["JS.CIPChirality"].bsAzacyclic.get (this.atomIndex)));
this.canBePseudo = (this.bondCount == 4 || this.isTrigonalPyramidal);
if (b != null) this.sphere = b.sphere + 1;
if (this.sphere == 1) {
this.rootSubstituent = this;
this.htPathPoints =  new java.util.Hashtable ();
} else if (b != null) {
this.rootSubstituent = b.rootSubstituent;
this.htPathPoints = this.rootSubstituent.htPathPoints;
}this.bsPath = (b == null ?  new JU.BS () : JU.BSUtil.copy (b.bsPath));
this.sp2Duplicate = d;
this.rootDistance = this.sphere;
if (b == null) {
this.bsPath.set (this.atomIndex);
} else if (this.sp2Duplicate && (!this.b$["JS.CIPChirality"].allowRule1bAlkenes || this.isKekuleAmbiguous)) {
} else if (a === this.b$["JS.CIPChirality"].root.atom) {
d = true;
this.rootDistance = 0;
this.rootSubstituent.spiroEnd = b;
} else if (this.bsPath.get (this.atomIndex)) {
d = true;
this.rootDistance = (e ? b.sphere : this.rootSubstituent.htPathPoints.get (Integer.$valueOf (this.atomIndex)).intValue ());
} else {
this.bsPath.set (this.atomIndex);
this.rootSubstituent.htPathPoints.put (Integer.$valueOf (this.atomIndex), Integer.$valueOf (this.rootDistance));
}this.isDuplicate = d;
if (JU.Logger.debugging) {
if (this.sphere < 50) this.myPath = (b != null ? b.myPath + "-" : "") + this;
JU.Logger.info ("new CIPAtom " + this.myPath);
}return this;
}, "JU.SimpleNode,JS.CIPChirality.CIPAtom,~B,~B,~B");
Clazz.defineMethod (c$, "getKekuleElementNumber", 
 function () {
var a = this.atom.getEdges ();
var b;
var c = 0;
var d = 0;
for (var e = a.length; --e >= 0; ) if ((b = a[e]).isCovalent ()) {
var f = b.getOtherNode (this.atom);
if (this.b$["JS.CIPChirality"].bsKekuleAmbiguous.get (f.getIndex ())) {
d++;
c += f.getElementNumber ();
}}
return c / d;
});
Clazz.defineMethod (c$, "updateRingList", 
function () {
var a = JU.BSUtil.newAndSetBit (this.atomIndex);
var b = this;
var c = -1;
while ((b = b.parent) != null && c != this.atomIndex) a.set (c = b.atomIndex);

if (a.cardinality () <= 7) {
for (var d = this.b$["JS.CIPChirality"].lstSmallRings.size (); --d >= 0; ) if (this.b$["JS.CIPChirality"].lstSmallRings.get (d).equals (a)) return;

this.b$["JS.CIPChirality"].lstSmallRings.addLast (a);
}});
Clazz.defineMethod (c$, "setNode", 
function () {
if (this.isSet || (this.isSet = true) && this.isDuplicate) return true;
var a = this.atom.getEdges ();
var b = a.length;
if (JU.Logger.debuggingHigh) JU.Logger.info ("set " + this);
var c = 0;
for (var d = 0; d < b; d++) {
var e = a[d];
if (!e.isCovalent ()) continue;
var f = e.getOtherNode (this.atom);
var g = (this.parent != null && this.parent.atom === f);
var h = e.getCovalentOrder ();
if (h == 2) {
if (this.elemNo > 10 || !this.b$["JS.CIPChirality"].isFirstRow (f)) h = 1;
 else {
this.isAlkene = true;
if (g) this.setEne ();
}}if (b == 1 && h == 1 && g) return this.isTerminal = true;
switch (h) {
case 3:
if (this.addAtom (c++, f, g, false, g) == null) return !(this.isTerminal = true);
case 2:
if (this.addAtom (c++, f, h != 2 || g, h == 2, g) == null) return !(this.isTerminal = true);
case 1:
if (g || this.addAtom (c++, f, h != 1 && this.elemNo <= 10, false, false) != null) break;
default:
return !(this.isTerminal = true);
}
}
this.isTerminal = (c == 0);
this.nAtoms = c;
for (; c < this.atoms.length; c++) this.atoms[c] = Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (null, this, false, true, false);

java.util.Arrays.sort (this.atoms);
return true;
});
Clazz.defineMethod (c$, "setEne", 
 function () {
this.parent.alkeneChild = null;
this.alkeneParent = (this.parent.alkeneParent == null ? this.parent : this.parent.alkeneParent);
this.alkeneParent.alkeneChild = this;
this.nextSP2 = this.parent;
if (this.parent.alkeneParent == null) this.parent.nextSP2 = this;
if (this.atom.getCovalentBondCount () == 2 && this.atom.getValence () == 4) {
this.parent.isAlkeneAtom2 = false;
this.alkeneParent.isEvenEne = !this.alkeneParent.isEvenEne;
} else {
this.isAlkeneAtom2 = true;
}});
Clazz.defineMethod (c$, "addAtom", 
function (a, b, c, d, e) {
if (a >= this.atoms.length) {
if (JU.Logger.debugging) JU.Logger.info (" too many bonds on " + this.atom);
return null;
}if (this.parent == null) {
if (b.getIsotopeNumber () == 1) {
if (++this.h1Count > 1) {
if (JU.Logger.debuggingHigh) JU.Logger.info (" second H atom found on " + this.atom);
return null;
}}}return this.atoms[a] = Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (b, this, d, c, e);
}, "~N,JU.SimpleNode,~B,~B,~B");
Clazz.defineMethod (c$, "sortSubstituents", 
function (a) {
var b =  Clazz.newIntArray (4, 0);
var c =  Clazz.newIntArray (4, 0);
this.ties = null;
var d = 0;
for (var e = 0; e < 4; e++) {
c[e] = this.priorities[e];
this.priorities[e] = 0;
}
if (JU.Logger.debuggingHigh) {
JU.Logger.info (this.b$["JS.CIPChirality"].root + "---sortSubstituents---" + this);
for (var f = 0; f < 4; f++) {
JU.Logger.info (this.b$["JS.CIPChirality"].getRuleName () + ": " + this + "[" + f + "]=" + this.atoms[f].myPath + " " + Integer.toHexString (c[f]));
}
JU.Logger.info ("---");
}var f = (this.rule4List != null && (this.b$["JS.CIPChirality"].currentRule == 6 || this.b$["JS.CIPChirality"].currentRule == 8));
for (var g = 0; g < 4; g++) {
var h = this.atoms[g];
for (var i = g + 1; i < 4; i++) {
var j = this.atoms[i];
var k = JU.Logger.debuggingHigh && j.isHeavy () && h.isHeavy ();
var l = (h.atom == null ? 1 : j.atom == null ? -1 : c[g] == c[i] ? 0 : c[i] < c[g] ? 1 : -1);
if (l == 0) l = (f ? this.checkRule4And5 (g, i) : h.checkPriority (j));
if (k) JU.Logger.info (this.dots () + "ordering " + this.id + "." + g + "." + i + " " + this + "-" + h + " vs " + j + " = " + l);
switch (l) {
case -2147483648:
if (f && a == 0) this.achiral = true;
b[g]++;
if (k) JU.Logger.info (this.dots () + this.atom + "." + j + " ends up with tie with " + h);
break;
case 1:
b[g]++;
this.priorities[g]++;
if (k) JU.Logger.info (this.dots () + this + "." + j + " B-beats " + h);
break;
case -1:
b[i]++;
this.priorities[i]++;
if (k) JU.Logger.info (this.dots () + this + "." + h + " A-beats " + j);
break;
case 0:
switch (l = this.sign (h.breakTie (j, a + 1))) {
case 0:
if (this.parent == null && this.b$["JS.CIPChirality"].currentRule >= 7 && ++d == 2 && h.spiroEnd != null && this.atoms[0].spiroEnd != null && h.spiroEnd.atom !== j.atom && this.atoms[0].spiroEnd !== h.spiroEnd) {
this.priorities[1]++;
var m = (h.spiroEnd.atom === this.atoms[0].atom ? i : g);
this.priorities[m]++;
b[m]++;
if (k) JU.Logger.info (this.dots () + this + " spiro Xaa'bb' tie resolved");
} else {
b[i]++;
if (k) JU.Logger.info (this.dots () + this + "." + j + " ends up with tie with " + h);
}break;
case 1:
b[g]++;
this.priorities[g]++;
if (k) JU.Logger.info (this.dots () + this + "." + j + " wins in tie with " + h);
break;
case -1:
b[i]++;
this.priorities[i]++;
if (k) JU.Logger.info (this.dots () + this + "." + h + " wins in tie with " + j);
break;
}
break;
}
if (this.doCheckPseudo) {
this.doCheckPseudo = false;
if (this.ties == null) this.ties =  new JU.Lst ();
this.ties.addLast ( Clazz.newIntArray (-1, [g, i, l]));
}}
}
var h =  new Array (4);
var i =  Clazz.newIntArray (4, 0);
var j = (this.rule4List == null ? null :  new Array (4));
var k =  new JU.BS ();
for (var l = 0; l < 4; l++) {
var m = b[l];
var n = h[m] = this.atoms[l];
i[m] = this.priorities[l];
if (this.rule4List != null) j[m] = this.rule4List[l];
if (n.atom != null) k.set (this.priorities[l]);
}
this.atoms = h;
this.priorities = i;
this.rule4List = j;
this.nPriorities = k.cardinality ();
if (this.ties != null) {
switch (this.ties.size ()) {
case 1:
switch (this.isAlkene ? 1 : this.checkPseudoHandedness (this.ties.get (0), b)) {
case 1:
case 2:
this.isPseudo = this.canBePseudo;
break;
}
break;
case 2:
break;
case 4:
if (this.nPriorities == 2) {
this.priorities[1]++;
this.priorities[this.atoms[0].spiroEnd === this.atoms[2].spiroEnd ? 3 : 2]++;
this.nPriorities = 4;
this.achiral = false;
}break;
}
}if ((JU.Logger.debuggingHigh) && this.atoms[2].atom != null && this.atoms[2].elemNo != 1) {
JU.Logger.info (this.dots () + this.atom + " nPriorities = " + this.nPriorities);
for (var m = 0; m < 4; m++) {
JU.Logger.info (this.dots () + this.myPath + "[" + m + "]=" + this.atoms[m] + " " + this.priorities[m] + " " + Integer.toHexString (this.priorities[m]) + " new");
}
JU.Logger.info (this.dots () + "-------");
}return (this.nPriorities >= this.bondCount);
}, "~N");
Clazz.defineMethod (c$, "dots", 
 function () {
return ".....................".substring (0, Math.min (20, this.sphere));
});
Clazz.defineMethod (c$, "breakTie", 
 function (a, b) {
if (JU.Logger.debugging && this.isHeavy () && a.isHeavy ()) JU.Logger.info (this.dots () + "tie for " + this + " and " + a + " at sphere " + b);
if (this.isDuplicate && a.isDuplicate && this.atom === a.atom && this.rootDistance == a.rootDistance) return 0;
var c = this.checkIsDuplicate (a);
if (c != 0) return c * (b + 1);
if (!this.setNode () || !a.setNode () || this.isTerminal && a.isTerminal || this.isDuplicate && a.isDuplicate) return 0;
if (this.isTerminal != a.isTerminal) return (this.isTerminal ? 1 : -1) * (b + 1);
if ((c = this.compareShallowly (a, b)) != 0) return c;
this.sortSubstituents (b);
a.sortSubstituents (b);
return this.compareDeeply (a, b);
}, "JS.CIPChirality.CIPAtom,~N");
Clazz.defineMethod (c$, "isHeavy", 
 function () {
return this.massNo > 1;
});
Clazz.defineMethod (c$, "compareShallowly", 
 function (a, b) {
for (var c = 0; c < this.nAtoms; c++) {
var d = this.atoms[c];
var e = a.atoms[c];
var f = d.checkCurrentRule (e);
if (f == -2147483648) f = 0;
if (f != 0) {
if (JU.Logger.debugging && d.isHeavy () && e.isHeavy ()) JU.Logger.info (d.dots () + "compareShallow " + c + " " + this + "." + d + "/" + a + "." + e + ": " + f * (b + 1));
return f * (b + 1);
}}
return 0;
}, "JS.CIPChirality.CIPAtom,~N");
Clazz.defineMethod (c$, "compareDeeply", 
 function (a, b) {
var c = (this.nAtoms == 0 ? 1 : 0);
var d = 2147483647;
for (var e = 0; e < this.nAtoms; e++) {
var f = this.atoms[e];
var g = a.atoms[e];
if (JU.Logger.debuggingHigh && f.isHeavy () && g.isHeavy ()) JU.Logger.info (f.dots () + "compareDeep sub " + this + "." + f + " " + a + "." + g);
var h = f.breakTie (g, b + 1);
if (h == 0) continue;
var i = Math.abs (h);
if (i < d) {
d = i;
c = h;
if (JU.Logger.debugging && f.isHeavy () && g.isHeavy ()) JU.Logger.info (f.dots () + "compareDeep sub " + f + " " + g + ": " + h);
}}
if (JU.Logger.debuggingHigh) JU.Logger.info (this.dots () + "compareDeep " + this + " " + a + ": " + c);
return c;
}, "JS.CIPChirality.CIPAtom,~N");
Clazz.overrideMethod (c$, "compareTo", 
function (a) {
var b;
return (a == null ? -1 : (this.atom == null) != (a.atom == null) ? (this.atom == null ? 1 : -1) : (b = this.checkRule1a (a)) != 0 ? b : (b = this.checkIsDuplicate (a)) != 0 ? b : !this.isDuplicate ? 0 : this.checkRule1b (a));
}, "JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "checkPriority", 
 function (a) {
var b;
return (a == null ? -1 : (this.atom == null) != (a.atom == null) ? (this.atom == null ? 1 : -1) : (b = this.checkCurrentRule (a)) == -2147483648 ? 0 : b);
}, "JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "checkIsDuplicate", 
 function (a) {
return a.isDuplicate == this.isDuplicate ? 0 : a.isDuplicate ? -1 : 1;
}, "JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "checkCurrentRule", 
function (a) {
switch (this.b$["JS.CIPChirality"].currentRule) {
default:
case 1:
return this.checkRule1a (a);
case 2:
return this.checkRule1b (a);
case 3:
return this.checkRule2 (a);
case 4:
return this.checkRule3 (a);
case 5:
return this.checkRules4ac (a, " sr SR PM");
case 7:
return this.checkRules4ac (a, " s r p m");
case 6:
case 8:
return 0;
}
}, "JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "checkRule1a", 
 function (a) {
return a.atom == null ? -1 : this.atom == null ? 1 : a.elemNo < this.elemNo ? -1 : a.elemNo > this.elemNo ? 1 : 0;
}, "JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "checkRule1b", 
 function (a) {
return a.isDuplicate != this.isDuplicate ? 0 : !this.b$["JS.CIPChirality"].allowRule1bAlkenes && (a.isAlkene || a.isAlkene) ? 0 : a.rootDistance != this.rootDistance ? (a.rootDistance > this.rootDistance ? -1 : 1) : 0;
}, "JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "checkRule2", 
 function (a) {
return a.massNo < this.massNo ? -1 : a.massNo > this.massNo ? 1 : 0;
}, "JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "checkRule3", 
 function (a) {
var b;
var c;
return this.isDuplicate || a.isDuplicate || !this.parent.isAlkeneAtom2 || !a.parent.isAlkeneAtom2 || !this.parent.alkeneParent.isEvenEne || !a.parent.alkeneParent.isEvenEne ? -2147483648 : this.parent === a.parent ? this.sign (this.breakTie (a, 0)) : (b = this.parent.getEZaux ()) < (c = a.parent.getEZaux ()) ? -1 : b > c ? 1 : 0;
}, "JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "getEZaux", 
 function () {
if (this.auxEZ == -1 && (this.auxEZ = this.alkeneParent.auxEZ) == -1) {
this.auxEZ = this.getEneWinnerChirality (this.alkeneParent, this, 4, false);
if (this.auxEZ == 0) this.auxEZ = 7;
}this.alkeneParent.auxEZ = this.auxEZ;
if (JU.Logger.debuggingHigh) JU.Logger.info ("getZaux " + this.alkeneParent + " " + this.auxEZ);
return this.auxEZ;
});
Clazz.defineMethod (c$, "getEneWinnerChirality", 
 function (a, b, c, d) {
var e = this.getEneEndWinner (a, a.nextSP2, c);
var f = (e == null || e.atom == null ? null : this.getEneEndWinner (b, b.nextSP2, c));
return this.b$["JS.CIPChirality"].getEneChirality (e, a, b, f, d, false);
}, "JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,~N,~B");
Clazz.defineMethod (c$, "getEneEndWinner", 
 function (a, b, c) {
var d = a.clone ();
if (d.parent !== b) d.addReturnPath (b, a);
var e = null;
for (var f = 1; f <= c; f++) if ((e = d.getTopSorted (f)) != null) break;

return (e == null || e.atom == null ? null : e);
}, "JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,~N");
Clazz.defineMethod (c$, "addReturnPath", 
 function (a, b) {
var c =  new JU.Lst ();
var d = this;
var e;
var f = b;
var g = a;
while (f.parent != null && f.parent.atoms[0] != null) {
if (JU.Logger.debuggingHigh) JU.Logger.info ("path:" + f.parent + "->" + f);
c.addLast (f = f.parent);
}
c.addLast (null);
for (var h = 0, i = c.size (); h < i; h++) {
f = c.get (h);
e = (f == null ? Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (null, this, this.isAlkene, true, false) : f.clone ());
e.sphere = d.sphere + 1;
d.replaceParentSubstituent (g, a, e);
if (h > 0 && d.isAlkene && !d.isAlkeneAtom2) {
if (a.isAlkeneAtom2) {
a.isAlkeneAtom2 = false;
d.alkeneParent = a;
}d.setEne ();
}a = d;
d = e;
g = b;
b = f;
}
}, "JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "replaceParentSubstituent", 
 function (a, b, c) {
for (var d = 0; d < 4; d++) if (this.atoms[d] === a || b == null && this.atoms[d].atom == null) {
if (JU.Logger.debuggingHigh) JU.Logger.info ("reversed: " + b + "->" + this + "->" + c);
this.parent = b;
this.atoms[d] = c;
java.util.Arrays.sort (this.atoms);
break;
}
}, "JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom,JS.CIPChirality.CIPAtom");
Clazz.defineMethod (c$, "checkRule4And5", 
 function (a, b) {
return (this.rule4List[a] == null && this.rule4List[b] == null ? 0 : this.rule4List[b] == null ? -1 : this.rule4List[a] == null ? 1 : this.compareMataPair (a, b));
}, "~N,~N");
Clazz.defineMethod (c$, "compareMataPair", 
 function (a, b) {
var c = this.rule4List[a].substring (1);
var d = this.rule4List[b].substring (1);
var e = false;
var f = (this.b$["JS.CIPChirality"].currentRule == 8);
var g = "";
var h = "";
if (this.atoms[a].nextChiralBranch != null) {
g = this.atoms[a].nextChiralBranch.getMataList (this.getFirstRef (c), f);
}if (this.atoms[b].nextChiralBranch != null) {
h = this.atoms[b].nextChiralBranch.getMataList (this.getFirstRef (d), f);
}e = (g.indexOf ("|") >= 0 || h.indexOf ("|") >= 0);
if (e) {
c += "|" + g;
d += "|" + h;
} else {
c += g;
d += h;
}if (true || JU.Logger.debugging) JU.Logger.info (this.dots () + this + " comparing " + this.atoms[a] + " " + c + " to " + this.atoms[b] + " " + d);
if (f || !e && c.length != d.length) {
return this.sign (c.compareTo (d));
}c = this.cleanRule4Str (c);
d = this.cleanRule4Str (d);
if (e) {
var i = JU.PT.split (c, "|");
var j = JU.PT.split (d, "|");
var k = 2147483647;
var l = 0;
c = i[0] + i[1];
d = j[0] + j[1];
for (var m = i.length; --m >= 1; ) {
for (var n = j.length; --n >= 1; ) {
var o = this.compareRule4PairStr (i[0] + i[m], j[0] + j[n], true);
l += o;
if (o != 0 && Math.abs (o) <= k) {
k = Math.abs (o);
c = i[0] + i[m];
d = j[0] + j[n];
}}
}
if (l == 0) return 0;
}if (c.length == 1 && "RS".indexOf (c) < 0) {
var i = this.checkEnantiomer (c, d, 0, c.length, " rs");
switch (i) {
case -1:
case 1:
this.canBePseudo = false;
this.doCheckPseudo = !this.isAxialRoot;
return i;
}
}return this.compareRule4PairStr (c, d, false);
}, "~N,~N");
Clazz.defineMethod (c$, "cleanRule4Str", 
 function (a) {
return (a.length > 1 ? JU.PT.replaceAllCharacters (a, "sr~", "") : a);
}, "~S");
Clazz.defineMethod (c$, "getFirstRef", 
 function (a) {
var b = a.indexOf ("R");
var c = a.indexOf ("S");
return (b < 0 && c < 0 ? null : c > 0 && (b < 0 || b > c) ? "S" : "R");
}, "~S");
Clazz.defineMethod (c$, "getMataList", 
 function (a, b) {
var c = 0;
for (var d = this.rule4List.length; --d >= 0; ) if (this.rule4List[d] != null) c++;

var e =  new Array (c);
for (var f = c, g = this.rule4List.length; --g >= 0; ) if (this.rule4List[g] != null) e[--f] = this.rule4List[g];

if (a == null) {
a = this.getMataRef (b);
} else {
for (var h = 0; h < c; h++) e[h] = "." + e[h].substring (1);

}return (a.length == 1 ? this.getMataSequence (e, a, b) : this.getMataSequence (e, "R", false) + "|" + this.getMataSequence (e, "S", false));
}, "~S,~B");
Clazz.defineMethod (c$, "getMataRef", 
 function (a) {
return (a ? "R" : this.rule4Count[1] > this.rule4Count[2] ? "R" : this.rule4Count[1] < this.rule4Count[2] ? "S" : "RS");
}, "~B");
Clazz.defineMethod (c$, "getMataSequence", 
 function (a, b, c) {
var d = a.length;
var e = 0;
var f =  new Array (d);
for (var g = d, h = this.rule4List.length; --h >= 0; ) {
if (this.rule4List[h] != null) {
--g;
f[g] = a[g];
if (this.atoms[h].nextChiralBranch != null) f[g] += this.atoms[h].nextChiralBranch.getMataList (b, c);
}}
var i = (c ? f : this.getMataSortedList (f, b));
for (var j = 0; j < d; j++) {
var k = i[j];
if (k.length > e) e = k.length;
}
var k = "";
var l;
for (var m = 1; m < e; m++) {
for (var n = 0; n < d; n++) {
var o = i[n];
if (m < o.length && (l = o.charAt (m)) != '~' && l != ';') k += l;
}
if (c) {
for (var o = 0; o < d; o++) {
var p = i[o];
if (m < p.length) i[o] = p.substring (0, m) + "~" + p.substring (m + 1);
}
java.util.Arrays.sort (i);
}}
return k;
}, "~A,~S,~B");
Clazz.defineMethod (c$, "compareRule4PairStr", 
 function (a, b, c) {
if (JU.Logger.debugging) JU.Logger.info (this.dots () + this.myPath + " Rule 4b comparing " + a + " " + b);
this.doCheckPseudo = false;
var d = a.length;
if (d == 0 || d != b.length) return 0;
var e = a.charAt (0);
var f = b.charAt (0);
for (var g = 1; g < d; g++) {
var h = (e == a.charAt (g));
if (h != (f == b.charAt (g))) return (c ? g : 1) * (h ? -1 : 1);
}
if (c) return 0;
if (e == f) return -2147483648;
if (!this.canBePseudo) this.b$["JS.CIPChirality"].root.canBePseudo = false;
this.doCheckPseudo = this.canBePseudo && (e == 'R' || e == 'S');
return e < f ? -1 : 1;
}, "~S,~S,~B");
Clazz.defineMethod (c$, "getMataSortedList", 
 function (a, b) {
var c = a.length;
var d =  new Array (c);
for (var e = 0; e < c; e++) d[e] = JU.PT.rep (a[e], b, "A");

java.util.Arrays.sort (d);
for (var f = 0; f < c; f++) d[f] = JU.PT.rep (d[f], "A", b);

if (JU.Logger.debuggingHigh) for (var g = 0; g < c; g++) JU.Logger.info ("Sorted Mata list " + g + " " + b + ": " + d[g]);

return d;
}, "~A,~S");
Clazz.defineMethod (c$, "createAuxiliaryRule4Data", 
function (a, b) {
var c = -1;
var d = "";
var e = (a == null ? "" : "~");
var f = false;
var g = false;
if (this.atom != null) {
this.rule4List =  new Array (4);
var h =  Clazz.newIntArray (4, 0);
var i = 0;
var j =  new Array (1);
for (var k = 0; k < 4; k++) {
var l = this.atoms[k];
if (l != null) l.setNode ();
if (l != null && !l.isDuplicate && !l.isTerminal) {
l.priority = this.priorities[k];
j[0] = null;
var m = l.createAuxiliaryRule4Data (a == null ? l : a, j);
if (j[0] != null) {
l.nextChiralBranch = j[0];
if (b != null) b[0] = j[0];
}this.rule4List[k] = l.priority + m;
if (l.nextChiralBranch != null || this.isChiralSequence (m)) {
h[i] = k;
i++;
d += m;
} else {
this.rule4List[k] = null;
}}}
var l = 0;
switch (i) {
case 0:
d = "";
break;
case 1:
break;
case 2:
if (a != null) {
l = (this.compareRule4aIsomers (h[0], h[1]));
switch (l) {
case 0:
f = true;
e = "~";
d = "";
break;
case -2147483648:
f = true;
break;
case -2:
case 2:
l -= this.sign (l);
d = "r";
case -1:
case 1:
f = true;
g = (d.indexOf ("r") >= 0);
d = "";
break;
}
}break;
case 3:
var m = 0;
var n = 0;
var o = 0;
for (var p = 0; p < 2; p++) {
for (var q = p + 1; q < 3; q++) {
o = (this.compareRule4aIsomers (h[p], h[q]));
switch (o) {
case -1:
case 1:
if (l == 0) {
l = o;
m = p;
n = q;
continue;
}p = q = 3;
l = 0;
break;
default:
break;
}
}
}
if (l != 0) {
h[0] = h[m];
h[1] = h[n];
}case 4:
e = "";
f = true;
break;
}
if (f) {
d = "";
if (b != null) b[0] = this;
}if (!f || l == -1 || l == 1 || l == -2147483648) {
if (this.isAlkene) {
if (!f && this.alkeneChild != null) {
var q = (b != null && b[0] === this.alkeneChild);
if (!this.isEvenEne || this.auxEZ == 7 && this.alkeneChild.bondCount >= 2 && !this.isKekuleAmbiguous) {
c = this.getEneWinnerChirality (this, this.alkeneChild, 8, !this.isEvenEne);
switch (c) {
case 17:
c = 1;
e = "R";
break;
case 18:
c = 2;
e = "S";
break;
case 5:
c = 1;
e = "R";
break;
case 6:
c = 2;
e = "S";
break;
}
if (c != 0) {
this.auxChirality = e;
this.addMataRef (this.sphere, this.priority, c);
d = "";
if (q) {
this.nextChiralBranch = this.alkeneChild;
b[0] = this;
}}}}} else if (a != null && (this.bondCount == 4 && this.nPriorities >= 3 - Math.abs (l) || this.isTrigonalPyramidal && this.nPriorities >= 2 - Math.abs (l))) {
if (f && l != -2147483648) {
switch (this.checkPseudoHandedness (h, null)) {
case 1:
e = (l == -1 ? "r" : "s");
break;
case 2:
e = (l == -1 ? "s" : "r");
break;
}
if (g) e = e.toUpperCase ();
d = "";
} else {
var q = this.clone ();
if (q.setNode ()) {
q.addReturnPath (null, this);
q.sortToRule (4);
c = q.checkHandedness ();
e = (c == 1 ? "R" : c == 2 ? "S" : "~");
if (JU.Logger.debugging) JU.Logger.info ("AUX " + e + " for " + q.myPath);
this.parent.addMataRef (this.sphere, this.priority, c);
}}this.auxChirality = e;
}}}e += d;
if (JU.Logger.debugging && !e.equals ("~")) JU.Logger.info ("creating aux " + this.myPath + e);
return e;
}, "JS.CIPChirality.CIPAtom,~A");
Clazz.defineMethod (c$, "sortByRule", 
 function (a) {
var b = this.b$["JS.CIPChirality"].root.canBePseudo;
var c = this.b$["JS.CIPChirality"].currentRule;
this.b$["JS.CIPChirality"].currentRule = a;
var d = this.sortSubstituents (0);
this.b$["JS.CIPChirality"].currentRule = c;
this.b$["JS.CIPChirality"].root.canBePseudo = b;
return d;
}, "~N");
Clazz.defineMethod (c$, "sortToRule", 
 function (a) {
for (var b = 1; b <= a; b++) if (this.sortByRule (b)) return;

}, "~N");
Clazz.defineMethod (c$, "isChiralSequence", 
 function (a) {
return a.indexOf ("R") >= 0 || a.indexOf ("S") >= 0 || a.indexOf ("r") >= 0 || a.indexOf ("s") >= 0;
}, "~S");
Clazz.defineMethod (c$, "addMataRef", 
 function (a, b, c) {
if (this.rule4Count == null) this.rule4Count =  Clazz.newIntArray (-1, [2147483647, 0, 0]);
var d = a * 10 + b;
if (d <= this.rule4Count[0]) {
if (d < this.rule4Count[0]) {
this.rule4Count[0] = d;
this.rule4Count[1] = this.rule4Count[2] = 0;
}this.rule4Count[c]++;
}if (JU.Logger.debugging) JU.Logger.info (this + " addMata " + a + " " + b + " " + c + " " + JU.PT.toJSON ("rule4Count", this.rule4Count));
if (this.parent != null) this.parent.addMataRef (a, b, c);
}, "~N,~N,~N");
Clazz.defineMethod (c$, "compareRule4aIsomers", 
 function (a, b) {
var c = this.rule4List[a];
var d = this.rule4List[b];
if (c.charAt (0) != d.charAt (0)) return -2147483648;
var e = c.length;
if (e != d.length) return -2147483648;
if (c.equals (d)) return 0;
var f = c + d;
var g = (f.indexOf ("R") >= 0 || f.indexOf ("S") >= 0);
if ((f.indexOf ("r") >= 0 || f.indexOf ("s") >= 0)) {
if (c.endsWith ("~")) return (2);
if (d.endsWith ("~")) return (-2);
}f = (g ? "~RS" : "~rs");
if (g) {
c = JU.PT.replaceAllCharacters (c, "rs", "~");
d = JU.PT.replaceAllCharacters (d, "rs", "~");
}var h = this.checkEnantiomer (c, d, 1, e, f);
if (h == -3) {
switch (this.compareMataPair (a, b)) {
case -1:
return -2;
case 1:
return 2;
}
}return h;
}, "~N,~N");
Clazz.defineMethod (c$, "checkEnantiomer", 
 function (a, b, c, d, e) {
var f = 0;
for (var g = c; g < d; g++) {
var h = e.indexOf (a.charAt (g));
var i = h + e.indexOf (b.charAt (g));
if (i == 0) continue;
if (i != 3) return -3;
if (f == 0) f = (h == 1 ? -1 : 1);
}
return f;
}, "~S,~S,~N,~N,~S");
Clazz.defineMethod (c$, "checkPseudoHandedness", 
 function (a, b) {
var c = (b == null ? a[0] : b[a[0]]);
var d = (b == null ? a[1] : b[a[1]]);
var e;
e = this.clone ();
e.atoms[c] = Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (null, e, false, false, false);
e.atoms[d] = Clazz.innerTypeInstance (JS.CIPChirality.CIPAtom, this, null).create (null, e, false, false, false);
e.addReturnPath (null, this);
e.sortByRule (1);
e.atoms[this.bondCount - 2] = this.atoms[Math.min (c, d)];
e.atoms[this.bondCount - 1] = this.atoms[Math.max (c, d)];
var f = e.checkHandedness ();
if (JU.Logger.debugging) {
for (var g = 0; g < 4; g++) JU.Logger.info ("pseudo " + f + " " + this.priorities[g] + " " + this.atoms[g].myPath);

}return f;
}, "~A,~A");
Clazz.defineMethod (c$, "getTopSorted", 
 function (a) {
this.sortByRule (a);
for (var b = 0; b < 4; b++) {
var c = this.atoms[b];
if (!c.sp2Duplicate) return this.priorities[b] == this.priorities[b + 1] ? null : this.atoms[b];
}
return null;
}, "~N");
Clazz.defineMethod (c$, "checkRules4ac", 
 function (a, b) {
if (this.isTerminal || this.isDuplicate) return 0;
var c = b.indexOf (this.auxChirality);
var d = b.indexOf (a.auxChirality);
return (c > d + 1 ? -1 : d > c + 1 ? 1 : 0);
}, "JS.CIPChirality.CIPAtom,~S");
Clazz.defineMethod (c$, "checkHandedness", 
function () {
var a = this.atoms[0].atom.getXYZ ();
var b = this.atoms[1].atom.getXYZ ();
var c = this.atoms[2].atom.getXYZ ();
JU.Measure.getNormalThroughPoints (a, b, c, this.b$["JS.CIPChirality"].vNorm, this.b$["JS.CIPChirality"].vTemp);
this.b$["JS.CIPChirality"].vTemp.setT ((this.atoms[3].atom == null ? this.atom : this.atoms[3].atom).getXYZ ());
this.b$["JS.CIPChirality"].vTemp.sub (a);
return (this.b$["JS.CIPChirality"].vTemp.dot (this.b$["JS.CIPChirality"].vNorm) > 0 ? 1 : 2);
});
Clazz.defineMethod (c$, "sign", 
function (a) {
return (a < 0 ? -1 : a > 0 ? 1 : 0);
}, "~N");
Clazz.defineMethod (c$, "clone", 
function () {
var a = null;
try {
a = Clazz.superCall (this, JS.CIPChirality.CIPAtom, "clone", []);
} catch (e) {
if (Clazz.exceptionOf (e, CloneNotSupportedException)) {
} else {
throw e;
}
}
a.id = this.b$["JS.CIPChirality"].ptID++;
a.atoms =  new Array (4);
a.priorities =  Clazz.newIntArray (4, 0);
a.htPathPoints = this.htPathPoints;
a.doCheckPseudo = false;
a.alkeneParent = null;
a.auxChirality = "~";
for (var b = 0; b < 4; b++) if (this.atoms[b] != null) a.atoms[b] = this.atoms[b];

a.ties = null;
return a;
});
Clazz.overrideMethod (c$, "toString", 
function () {
return (this.atom == null ? "<null>" : "[" + this.b$["JS.CIPChirality"].currentRule + "." + this.sphere + "," + this.id + "." + this.atom.getAtomName () + (this.isDuplicate ? "*(" + this.rootDistance + ")" : "") + (this.auxChirality == null ? "" : this.auxChirality) + "]");
});
c$ = Clazz.p0p ();
};
Clazz.defineStatics (c$,
"NO_CHIRALITY", 0,
"TIED", 0,
"B_WINS", 1,
"A_WINS", -1,
"DIASTEREOMERIC", -3,
"DIASTEREOMERIC_A_WINS", -2,
"DIASTEREOMERIC_B_WINS", 2,
"IGNORE", -2147483648,
"NOT_RELEVANT", -2147483648,
"STEREO_UNDETERMINED", -1,
"STEREO_R", 1,
"STEREO_S", 2,
"STEREO_M", 17,
"STEREO_P", 18,
"STEREO_Z", 5,
"STEREO_E", 6,
"STEREO_BOTH_RS", 3,
"STEREO_BOTH_EZ", 7,
"RULE_1a", 1,
"RULE_1b", 2,
"RULE_2", 3,
"RULE_3", 4,
"RULE_4a", 5,
"RULE_4b", 6,
"RULE_4c", 7,
"RULE_5", 8,
"TRIGONALITY_MIN", 0.2,
"MAX_PATH", 50,
"SMALL_RING_MAX", 7);
});
